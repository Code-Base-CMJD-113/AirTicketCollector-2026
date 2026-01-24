package lk.ijse.cmjd113.AirTicketCollector.controller;


import lk.ijse.cmjd113.AirTicketCollector.dto.UserDTO;
import lk.ijse.cmjd113.AirTicketCollector.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserDataController {

  private final UserService userService;

  @GetMapping("/{userId}")
  public ResponseEntity<UserDTO> getSelectedUser(@PathVariable String userId) {
    return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
  }
  @PostMapping
  public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
  }
  @GetMapping
  public  ResponseEntity<List<UserDTO>> getAllUsers(){
    return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
  }
  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable String userId){
    userService.deleteUser(userId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  @PatchMapping("/{userId}")
  public ResponseEntity<Void> updateUser(@PathVariable String userId,@RequestBody UserDTO userDto){
    userService.updateUser(userId, userDto);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
