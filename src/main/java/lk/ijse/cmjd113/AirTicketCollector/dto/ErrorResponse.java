package lk.ijse.cmjd113.AirTicketCollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse implements Serializable {
    String errorMessage;
    String customStatus;
}
