package lk.ijse.cmjd113.AirTicketCollector.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.AirTicketCollector.dao.UserDao;
import lk.ijse.cmjd113.AirTicketCollector.dto.UserDTO;
import lk.ijse.cmjd113.AirTicketCollector.entities.UserEntity;
import lk.ijse.cmjd113.AirTicketCollector.exception.DataNotFoundException;
import lk.ijse.cmjd113.AirTicketCollector.service.UserService;
import lk.ijse.cmjd113.AirTicketCollector.util.IDGenerate;
import lk.ijse.cmjd113.AirTicketCollector.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    private final UserDao userDao;
    private final Mapper mapper;
    @Override
    public void saveUser(UserDTO userDTO) {
       userDTO.setUserId(IDGenerate.userId());
       userDao.save(mapper.toUserEntity(userDTO));
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        var foundUser = userDao.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User not found"));

        foundUser.setRole(userDTO.getRole());
        foundUser.setEmail(userDTO.getEmail());
        foundUser.setFullName(userDTO.getFullName());
        foundUser.setPhone(userDTO.getPhone());
        foundUser.setPassword(userDTO.getPassword());
    }

    @Override
    public void deleteUser(String userId) {
        var foundUser = userDao.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        userDao.delete(foundUser);
    }

    @Override
    public UserDTO getUser(String userId) {
        var foundUser = userDao.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        return mapper.toUserDTO(foundUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapper.toUserDTOList(userDao.findAll());
    }
}
