package lk.ijse.cmjd113.AirTicketCollector.controller;

import lk.ijse.cmjd113.AirTicketCollector.dto.FlightDTO;
import lk.ijse.cmjd113.AirTicketCollector.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flight")
@RequiredArgsConstructor
public class FlightDataController {

  private final FlightService flightService;

  @GetMapping("/{flightId}")
  public ResponseEntity<FlightDTO> getSelectedFlight(@PathVariable String flightId) {
    return new ResponseEntity<>(flightService.getFlight(flightId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Void> saveFlight(@RequestBody FlightDTO flight) {
    flightService.saveFlight(flight);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
  @GetMapping
  public  ResponseEntity<List<FlightDTO>> getAllFlights(){
    return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
  }
  @DeleteMapping("/{flightId}")
  public ResponseEntity<Void> deleteFlight(@PathVariable String flightId){
    flightService.deleteFlight(flightId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  @PatchMapping("/{flightId}")
  public ResponseEntity<Void> updatePassenger(@PathVariable String flightId,@RequestBody FlightDTO flight){
    flightService.updateFlight(flightId, flight);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
