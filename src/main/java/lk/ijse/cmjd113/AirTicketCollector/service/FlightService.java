package lk.ijse.cmjd113.AirTicketCollector.service;

import lk.ijse.cmjd113.AirTicketCollector.dto.FlightDTO;

import java.util.List;

public interface FlightService {
    void saveFlight(FlightDTO flightDTO);
    void updateFlight(String flightId,FlightDTO flightDTO);
    void deleteFlight(String flightId);
    FlightDTO getFlight(String flightId);
    List<FlightDTO> getAllFlights();
}
