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
        return new AirportDTO(
                airportId,
                "CMB",
                "Bandaranayake International Airport",
                "Katunayaka",
                "SL"
        );
    }

    @Override
    public List<AirportDTO> getAllAirports() {
        return List.of(
                new AirportDTO("APT-001", "CMB", "Bandaranaike International Airport", "Katunayake", "SL"),
                new AirportDTO("APT-002", "HRI", "Mattala Rajapaksa International Airport", "Hambantota", "SL"),
                new AirportDTO("APT-003", "DEL", "Indira Gandhi International Airport", "New Delhi", "IN"),
                new AirportDTO("APT-004", "DXB", "Dubai International Airport", "Dubai", "AE"),
                new AirportDTO("APT-005", "LHR", "Heathrow Airport", "London", "GB")
        );
    }

    @Override
    public void deleteAirport(String airportId) {
        System.out.println("Deleted Airport is: " + airportId);
    }

    @Override
    public void updateAirport(String airportId, AirportDTO updatedAirport) {
        updatedAirport.setAirportId(airportId);
        System.out.println("Updated ID is : "+airportId);
        System.out.println("Updated Airport is :"+updatedAirport);
    }
}
