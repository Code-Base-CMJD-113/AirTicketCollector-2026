package lk.ijse.cmjd113.AirTicketCollector.dto.secure;

import lk.ijse.cmjd113.AirTicketCollector.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO implements Serializable {
    private String userId;
    private String fullName;
    private String email;
    private String password;
    private Role role;
    private String phone;
}
