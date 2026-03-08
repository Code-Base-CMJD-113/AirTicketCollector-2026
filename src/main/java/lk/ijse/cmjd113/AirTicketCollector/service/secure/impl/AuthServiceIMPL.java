package lk.ijse.cmjd113.AirTicketCollector.service.secure.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.AirTicketCollector.dto.secure.JWTResponseDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.secure.LoginDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.secure.UserDTO;
import lk.ijse.cmjd113.AirTicketCollector.service.secure.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    @Override
    public JWTResponseDTO signUp(UserDTO user) {
        return null;
    }

    @Override
    public JWTResponseDTO login(LoginDTO login) {
        return null;
    }
}
