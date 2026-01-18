package lk.ijse.cmjd113.AirTicketCollector.controller;

import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.util.IDGenerate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {
    // Save an airport
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> saveAirport(
            @RequestBody AirportDTO airportDTO){
        airportDTO.setAirportId(IDGenerate.airportId());
        return new ResponseEntity<>(airportDTO, HttpStatus.CREATED);
    }
    //Get Selected Airport
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> getSelectedAirport(@PathVariable ("id") String airportId){
        var airportDTO = new AirportDTO(
                airportId,
                "CMB",
                "Bandaranayake International Airport",
                "Katunayaka",
                "SL"
        );
        return new ResponseEntity<>(airportDTO,HttpStatus.OK);
    }
}
