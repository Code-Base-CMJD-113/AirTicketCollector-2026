package lk.ijse.cmjd113.AirTicketCollector.controller;

import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.util.IDGenerate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    //Get All Airports
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AirportDTO>> getAllAirports(){
       List<AirportDTO> allAirports = List.of(
               new AirportDTO("APT-001", "CMB", "Bandaranaike International Airport", "Katunayake", "SL"),
               new AirportDTO("APT-002", "HRI", "Mattala Rajapaksa International Airport", "Hambantota", "SL"),
               new AirportDTO("APT-003", "DEL", "Indira Gandhi International Airport", "New Delhi", "IN"),
               new AirportDTO("APT-004", "DXB", "Dubai International Airport", "Dubai", "AE"),
               new AirportDTO("APT-005", "LHR", "Heathrow Airport", "London", "GB")
       );
       return new ResponseEntity<>(allAirports,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable ("id") String airportId){
        System.out.println("Deleted Id is: "+ airportId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAirport(
           @PathVariable ("id") String airportId,
           @RequestBody AirportDTO updatedAirport){
        updatedAirport.setAirportId(airportId);
        System.out.println("Updated ID is : "+airportId);
        System.out.println("Updated Airport is :"+updatedAirport);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
