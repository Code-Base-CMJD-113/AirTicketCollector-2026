package lk.ijse.cmjd113.AirTicketCollector.service.impl;

import lk.ijse.cmjd113.AirTicketCollector.dto.UserDTO;
import lk.ijse.cmjd113.AirTicketCollector.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements UserService {
    @Override
    public void saveUser(UserDTO userDTO) {

    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {

    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public UserDTO getUser(String userId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }
}
