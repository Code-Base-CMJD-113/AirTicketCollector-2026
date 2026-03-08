package lk.ijse.cmjd113.AirTicketCollector.service.secure.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.AirTicketCollector.dao.UserDao;
import lk.ijse.cmjd113.AirTicketCollector.dto.secure.JWTResponseDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.secure.LoginDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.secure.UserDTO;
import lk.ijse.cmjd113.AirTicketCollector.entities.secure.UserEntity;
import lk.ijse.cmjd113.AirTicketCollector.securityConfig.JWTUtils;
import lk.ijse.cmjd113.AirTicketCollector.service.secure.AuthService;
import lk.ijse.cmjd113.AirTicketCollector.util.IDGenerate;
import lk.ijse.cmjd113.AirTicketCollector.util.ObjMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    private final JWTUtils jwtUtils;
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ObjMapper  objMapper;

    @Override
    public JWTResponseDTO signUp(UserDTO user) {
        if(userDao.existsByEmail(user.getEmail())){
            throw new IllegalArgumentException("Email Already Exists");
        }
        //Gen ID
        user.setUserId(IDGenerate.userId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser
                = userDao.save(objMapper.toUserEntity(user));

        var token = jwtUtils.generateToken(
                savedUser.getEmail(),
                savedUser.getAuthorities()
        );
        return JWTResponseDTO
                .builder()
                .token(token)
                .build();
    }

    @Override
    public JWTResponseDTO login(LoginDTO login) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                     login.getEmail(), login.getPassword()
                ));
        //Fetch user
        var authUser = userDao.findByEmail(login.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Invalid email or password"));

        var token = jwtUtils.generateToken(
                authUser.getUsername(),
                authUser.getAuthorities()

        );
        return JWTResponseDTO.builder()
                .token(token)
                .build();
    }
}
