package lk.ijse.cmjd113.AirTicketCollector.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.AirTicketCollector.dao.AirportDao;
import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.entities.AirportEntity;
import lk.ijse.cmjd113.AirTicketCollector.service.AirportService;
import lk.ijse.cmjd113.AirTicketCollector.util.IDGenerate;
import lk.ijse.cmjd113.AirTicketCollector.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class AirportServiceIMPL implements AirportService {
    private final AirportDao airportDao;
    private final Mapper mapper;
    @Override
    public void saveAirport(AirportDTO airport) {
         airport.setAirportId(IDGenerate.airportId());
        AirportEntity airportEntity =
                mapper.toAirportEntity(airport);
        airportDao.save(airportEntity);
    }

    @Override
    public AirportDTO getSelectedAirport(String airportId) {
        var foundAirport = airportDao.findById(airportId)
                .orElseThrow(() -> new RuntimeException("Data Not Found"));
        return mapper.toAirportDTO(foundAirport);
    }

    @Override
    public List<AirportDTO> getAllAirports() {
        return mapper.toAirportDTOList( airportDao.findAll());
    }

    @Override
    public void deleteAirport(String airportId) {
        var foundAirport = airportDao.findById(airportId)
                .orElseThrow(() -> new RuntimeException("Data Not Found"));
        airportDao.delete(foundAirport);
    }

    @Override
    public void updateAirport(String airportId, AirportDTO updatedAirport) {
        updatedAirport.setAirportId(airportId);
        System.out.println("Updated ID is : "+airportId);
        System.out.println("Updated Airport is :"+updatedAirport);
    }
}
