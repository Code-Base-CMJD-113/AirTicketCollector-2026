package lk.ijse.cmjd113.AirTicketCollector.service.impl;

import lk.ijse.cmjd113.AirTicketCollector.dto.FlightDTO;
import lk.ijse.cmjd113.AirTicketCollector.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightServiceIMPL implements FlightService {
    @Override
    public void saveFlight(FlightDTO flightDTO) {

    }

    @Override
    public void updateFlight(String flightId, FlightDTO flightDTO) {

    }

    @Override
    public void deleteFlight(String flightId) {

    }

    @Override
    public FlightDTO getFlight(String flightId) {
        return null;
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        return List.of();
    }
}
