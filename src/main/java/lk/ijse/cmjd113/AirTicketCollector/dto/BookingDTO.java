package lk.ijse.cmjd113.AirTicketCollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO implements Serializable {
    private String bookingId;
    private LocalDateTime bookingDate;
    private Integer seatCount;
    private BigDecimal totalAmount;
    private BookingStatus status;
    private String flightId;
    private String userId;
}
