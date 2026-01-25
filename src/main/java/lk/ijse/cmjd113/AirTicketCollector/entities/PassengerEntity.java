package lk.ijse.cmjd113.AirTicketCollector.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "passengers")
public class PassengerEntity implements Serializable {
    @Id
    private String passengerId;
    private String fullName;
    private int age;
    private String gender;
    private int seatNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private BookingEntity bookingId;
}
