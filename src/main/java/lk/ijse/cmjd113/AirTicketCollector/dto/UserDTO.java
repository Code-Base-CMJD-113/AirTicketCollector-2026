package lk.ijse.cmjd113.AirTicketCollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements Serializable {
    private String userId;
    private String fullName;
    private String email;
    private String password;
    private Role role;
    private String phone;
}
