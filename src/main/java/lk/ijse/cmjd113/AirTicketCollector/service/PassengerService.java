package lk.ijse.cmjd113.AirTicketCollector.service;

import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.PassengerDTO;

import java.util.List;

public interface PassengerService {
     void savePassenger(PassengerDTO airport);
     PassengerDTO getSelectedPassenger(String airportId);
     List<PassengerDTO> getAllPassengers();
     void deletePassenger(String passengerId);
     void updatePassenger(String passengerId,PassengerDTO updatePassenger);
}
