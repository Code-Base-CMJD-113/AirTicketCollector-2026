package lk.ijse.cmjd113.AirTicketCollector.controller;

import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;
    // Save an airport
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> saveAirport(
            @RequestBody AirportDTO airportDTO){
        airportService.saveAirport(airportDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //Get Selected Airport
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> getSelectedAirport(@PathVariable ("id") String airportId){
        return new ResponseEntity<>(airportService.getSelectedAirport(airportId),HttpStatus.OK);
    }
    //Get All Airports
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AirportDTO>> getAllAirports(){
       return new ResponseEntity<>(airportService.getAllAirports(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable ("id") String airportId){
        airportService.deleteAirport(airportId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAirport(
           @PathVariable ("id") String airportId,
           @RequestBody AirportDTO updatedAirport){
          airportService.updateAirport(airportId,updatedAirport);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
