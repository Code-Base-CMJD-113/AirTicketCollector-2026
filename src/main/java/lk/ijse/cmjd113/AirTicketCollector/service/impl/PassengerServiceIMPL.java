package lk.ijse.cmjd113.AirTicketCollector.service.impl;

import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.PassengerDTO;
import lk.ijse.cmjd113.AirTicketCollector.service.PassengerService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class PassengerServiceIMPL implements PassengerService {
    @Override
    public void savePassenger(PassengerDTO passenger) {
        System.out.println(passenger);
    }

    @Override
    public PassengerDTO getSelectedPassenger(String airportId) {
        return null;
    }

    @Override
    public List<PassengerDTO> getAllPassengers() {
        return List.of();
    }

    @Override
    public void deletePassenger(String passengerId) {

    }

    @Override
    public void updatePassenger(String passengerId, PassengerDTO updatePassenger) {

    }
}
