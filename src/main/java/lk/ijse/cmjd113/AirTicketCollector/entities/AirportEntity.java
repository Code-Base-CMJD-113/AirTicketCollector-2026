package lk.ijse.cmjd113.AirTicketCollector.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "airport")
public class AirportEntity implements Serializable {
    @Id
    private String airportId;
    @Column(nullable = false, unique = true)
    private String airportCode;
    private String name;
    private String city;
    private String country;
}
