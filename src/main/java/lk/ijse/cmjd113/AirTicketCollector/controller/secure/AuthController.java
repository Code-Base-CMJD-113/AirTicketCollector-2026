package lk.ijse.cmjd113.AirTicketCollector.controller.secure;

import lk.ijse.cmjd113.AirTicketCollector.dto.secure.JWTResponseDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.secure.LoginDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.secure.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    @PostMapping("/signup")
    public ResponseEntity<JWTResponseDTO> signUp(@RequestBody UserDTO user) {
        return null;
    }
    @PostMapping("/login")
    public ResponseEntity<JWTResponseDTO> login(@RequestBody LoginDTO login) {
        return null;
    }
}
