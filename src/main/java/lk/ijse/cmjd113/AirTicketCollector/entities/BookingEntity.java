package lk.ijse.cmjd113.AirTicketCollector.entities;

import jakarta.persistence.*;
import lk.ijse.cmjd113.AirTicketCollector.dto.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bookings")
public class BookingEntity implements Serializable {
    @Id
    private String bookingId;
    private LocalDateTime bookingDate;
    private int seatCount;
    private double totalAmount;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private FlightEntity flightId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
