package lk.ijse.cmjd113.AirTicketCollector.service.impl;

import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.service.AirportService;
import lk.ijse.cmjd113.AirTicketCollector.util.IDGenerate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AirportServiceIMPL implements AirportService {
    @Override
    public AirportDTO saveAirport(AirportDTO airport) {
        airport.setAirportId(IDGenerate.airportId());
        return airport;
    }

    @Override
    public AirportDTO getSelectedAirport(String airportId) {
        return null;
    }

    @Override
    public List<AirportDTO> getAllAirports() {
        return List.of();
    }

    @Override
    public void deleteAirport(String airportId) {

    }

    @Override
    public void updateAirport(String airportId, AirportDTO updatedAirport) {

    }
}
