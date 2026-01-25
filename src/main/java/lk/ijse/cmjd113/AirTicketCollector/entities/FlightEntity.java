package lk.ijse.cmjd113.AirTicketCollector.entities;

import jakarta.persistence.*;
import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "flights")
public class FlightEntity implements Serializable {
    @Id
    private String flightNo;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double baseFare;
    @Enumerated(EnumType.STRING)
    private FlightStatus status;
    @JoinColumn(name = "dep_airport")
    @ManyToOne(fetch = FetchType.LAZY)
    private AirportEntity departureAirport;
    @JoinColumn(name = "arr_airport")
    @ManyToOne(fetch = FetchType.LAZY)
    private AirportEntity arrivalAirport;
}
