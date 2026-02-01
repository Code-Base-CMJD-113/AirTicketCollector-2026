package lk.ijse.cmjd113.AirTicketCollector.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.AirTicketCollector.dao.BookingDao;
import lk.ijse.cmjd113.AirTicketCollector.dao.PassengerDao;
import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.PassengerDTO;
import lk.ijse.cmjd113.AirTicketCollector.entities.BookingEntity;
import lk.ijse.cmjd113.AirTicketCollector.entities.PassengerEntity;
import lk.ijse.cmjd113.AirTicketCollector.exception.DataNotFoundException;
import lk.ijse.cmjd113.AirTicketCollector.service.PassengerService;
import lk.ijse.cmjd113.AirTicketCollector.util.IDGenerate;
import lk.ijse.cmjd113.AirTicketCollector.util.ObjMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.ReflectiveScan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class PassengerServiceIMPL implements PassengerService {
    private final ObjMapper objMapper;
    private final PassengerDao passengerDao;
    private final BookingDao bookingDao;

    @Override
    public void savePassenger(PassengerDTO passenger) {
        var foundBooking = bookingDao.findById(passenger.getBookingId())
                .orElseThrow(() -> new DataNotFoundException("Booking not found"));

        var passengerEntity = objMapper.toPassengerEntity(passenger);
        passengerEntity.setPassengerId(IDGenerate.passengerId());
        passengerEntity.setBookingId(foundBooking);
        passengerDao.save(passengerEntity);
    }

    @Override
    public PassengerDTO getSelectedPassenger(String passengerId) {
        var foundPassenger = passengerDao.findById(passengerId)
                .orElseThrow(() -> new DataNotFoundException("Passenger not found"));
        return objMapper.toPassengerDTO(foundPassenger);
    }

    @Override
    public List<PassengerDTO> getAllPassengers() {
        return objMapper.toPassengerDTOList(passengerDao.findAll());
    }

    @Override
    public void deletePassenger(String passengerId) {
     passengerDao.findById(passengerId)
                .orElseThrow(() -> new DataNotFoundException("Passenger not found"));
     passengerDao.deleteById(passengerId);
    }

    @Override
    public void updatePassenger(String passengerId, PassengerDTO updatePassenger) {
        var foundPassenger = passengerDao.findById(passengerId)
                .orElseThrow(() -> new DataNotFoundException("Passenger not found"));

        var foundBooking = bookingDao.findById(updatePassenger.getBookingId())
                .orElseThrow(() -> new DataNotFoundException("Booking not found"));

        foundPassenger.setAge(updatePassenger.getAge());
        foundPassenger.setBookingId(foundBooking);
        foundPassenger.setGender(updatePassenger.getGender());
        foundPassenger.setSeatNumber(updatePassenger.getSeatNumber());
        foundPassenger.setFullName(updatePassenger.getFullName());


    }
}
