package lk.ijse.cmjd113.AirTicketCollector.controller;

import lk.ijse.cmjd113.AirTicketCollector.dto.PassengerDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.UserDTO;
import lk.ijse.cmjd113.AirTicketCollector.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passengers")
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService passengerService;
    @PostMapping
    public ResponseEntity<Void> savePassenger(@RequestBody PassengerDTO passengerDTO) {
        passengerService.savePassenger(passengerDTO);
        return new  ResponseEntity<>(HttpStatus.CREATED);
    }
    public ResponseEntity<PassengerDTO> getSelectedPassenger(PassengerDTO passengerDTO) {
        return null;
    }
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
        return null;
    }
    public ResponseEntity <Void>  deletePassenger(String passengerId) {
        return null;
    }
    public ResponseEntity<Void> updatePassenger(String passengerId,PassengerDTO passengerDTO) {
        return null;
    }

}
