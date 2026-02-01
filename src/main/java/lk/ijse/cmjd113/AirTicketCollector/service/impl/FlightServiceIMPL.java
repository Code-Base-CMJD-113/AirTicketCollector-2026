package lk.ijse.cmjd113.AirTicketCollector.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.AirTicketCollector.dao.AirportDao;
import lk.ijse.cmjd113.AirTicketCollector.dao.FlightDao;
import lk.ijse.cmjd113.AirTicketCollector.dto.FlightDTO;
import lk.ijse.cmjd113.AirTicketCollector.entities.AirportEntity;
import lk.ijse.cmjd113.AirTicketCollector.entities.FlightEntity;
import lk.ijse.cmjd113.AirTicketCollector.exception.DataNotFoundException;
import lk.ijse.cmjd113.AirTicketCollector.service.FlightService;
import lk.ijse.cmjd113.AirTicketCollector.util.IDGenerate;
import lk.ijse.cmjd113.AirTicketCollector.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class FlightServiceIMPL implements FlightService {
    private final FlightDao flightDao;
    private final AirportDao airportDao;
    private final Mapper mapper;
    @Override
    public void saveFlight(FlightDTO flightDTO) {
        //Fetch Airport data
        var depAirport = airportDao.findAirportByAirportCode(flightDTO.getDepartureAirportCode())
                .orElseThrow(() -> new DataNotFoundException("Departure Airport Not Found"));
        var arrAirport = airportDao.findAirportByAirportCode(flightDTO.getArrivalAirportCode())
                .orElseThrow(() -> new DataNotFoundException("Arrival Airport Not Found"));

        FlightEntity flightEntity = mapper.toFlightEntity(flightDTO);
        flightEntity.setDepartureAirport(depAirport);
        flightEntity.setArrivalAirport(arrAirport);
        flightEntity.setFlightNo(IDGenerate.flightId());
        flightDao.save(flightEntity);
    }

    @Override
    public void updateFlight(String flightId, FlightDTO flightDTO) {

    }

    @Override
    public void deleteFlight(String flightId) {
        flightDao.findById(flightId)
                        .orElseThrow(() -> new DataNotFoundException("Flight Not Found"));
     flightDao.deleteById(flightId);
    }

    @Override
    public FlightDTO getFlight(String flightId) {
        var foundFlight =
                flightDao.findById(flightId)
                        .orElseThrow(() -> new DataNotFoundException("Flight Not Found"));
    return mapper.toFlightDTO(foundFlight);
    }

    @Override
    public List<FlightDTO> getAllFlights() {
      return  mapper.toFlightDTOList(flightDao.findAll());
    }
}
