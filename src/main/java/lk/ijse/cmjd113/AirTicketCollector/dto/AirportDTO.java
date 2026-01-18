package lk.ijse.cmjd113.AirTicketCollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AirportDTO implements Serializable {
    private String airportId;
    private String airportCode;
    private String name;
    private String city;
    private String country;
}
