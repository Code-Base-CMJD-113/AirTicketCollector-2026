package lk.ijse.cmjd113.AirTicketCollector.controller;

import lk.ijse.cmjd113.AirTicketCollector.dto.PassengerDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.UserDTO;
import lk.ijse.cmjd113.AirTicketCollector.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<PassengerDTO> getSelectedPassenger(@PathVariable ("id") String passengerId) {
       return new ResponseEntity<>(passengerService.getSelectedPassenger(passengerId), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void>  deletePassenger(@PathVariable ("id") String passengerId) {
        passengerService.deletePassenger(passengerId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassenger(@PathVariable ("id") String passengerId, @RequestBody PassengerDTO passengerDTO) {
      passengerService.updatePassenger(passengerId,passengerDTO);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
