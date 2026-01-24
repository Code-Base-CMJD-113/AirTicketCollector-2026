package lk.ijse.cmjd113.AirTicketCollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PassengerDTO implements Serializable {
    private String passengerId;
    private String fullName;
    private int age;
    private String gender;
    private int seatNumber;
    private String bookingId;
}
