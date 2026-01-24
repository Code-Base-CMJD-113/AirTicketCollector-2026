package lk.ijse.cmjd113.AirTicketCollector.service;

import lk.ijse.cmjd113.AirTicketCollector.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(String userId,UserDTO userDTO);
    void deleteUser(String userId);
    UserDTO getUser(String userId);
    List<UserDTO> getAllUsers();
}
