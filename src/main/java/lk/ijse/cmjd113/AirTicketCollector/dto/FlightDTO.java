package lk.ijse.cmjd113.AirTicketCollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightDTO implements Serializable {
    private String flightNo;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double baseFare;
    private FlightStatus status;
    private String departureAirport;
    private String arrivalAirport;
}
