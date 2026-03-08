package lk.ijse.cmjd113.AirTicketCollector.service.secure;

import lk.ijse.cmjd113.AirTicketCollector.dto.secure.JWTResponseDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.secure.LoginDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.secure.UserDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthService {
    JWTResponseDTO signUp(@RequestBody UserDTO user);
    JWTResponseDTO login(@RequestBody LoginDTO login);
}
