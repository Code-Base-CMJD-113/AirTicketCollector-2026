package lk.ijse.cmjd113.AirTicketCollector.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.AirTicketCollector.dao.BookingDao;
import lk.ijse.cmjd113.AirTicketCollector.dao.FlightDao;
import lk.ijse.cmjd113.AirTicketCollector.dao.UserDao;
import lk.ijse.cmjd113.AirTicketCollector.dto.BookingDTO;
import lk.ijse.cmjd113.AirTicketCollector.entities.BookingEntity;
import lk.ijse.cmjd113.AirTicketCollector.exception.DataNotFoundException;
import lk.ijse.cmjd113.AirTicketCollector.exception.DataSaveException;
import lk.ijse.cmjd113.AirTicketCollector.service.BookingService;
import lk.ijse.cmjd113.AirTicketCollector.util.IDGenerate;
import lk.ijse.cmjd113.AirTicketCollector.util.ObjMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingServiceIMPL implements BookingService {

    private final BookingDao bookingDao;
    private final ObjMapper objMapper;
    private final FlightDao flightDao;
    private final UserDao userDao;

    @Override
    public void saveBooking(BookingDTO booking) {

        var foundFlight = flightDao.findById(booking.getFlightId())
                        .orElseThrow(() -> new DataNotFoundException("Flight not found"));

        var foundUser = userDao.findById(booking.getUserId())
                .orElseThrow(() -> new DataNotFoundException("User not found"));

        var bookingEntity = objMapper.toBookingEntity(booking);
        bookingEntity.setFlightId(foundFlight);
        bookingEntity.setUser(foundUser);
        bookingEntity.setBookingId(IDGenerate.bookingId());

        //Todo:Update seat count
        var availableSeats = flightDao.getAvailableSeats(booking.getFlightId());
        if(availableSeats == 0){
            throw new DataSaveException("No available seats found");
        }
        bookingDao.save(bookingEntity);
        flightDao.deductAvlSeats(booking.getSeatCount(),booking.getFlightId());
    }

    @Override
    public void updateBooking(String bookingId, BookingDTO booking) {
        var foundBooking = bookingDao.findById(bookingId)
                .orElseThrow(() -> new DataNotFoundException("Booking not found"));

        var foundFlight = flightDao.findById(booking.getFlightId())
                .orElseThrow(() -> new DataNotFoundException("Flight not found"));

        var foundUser = userDao.findById(booking.getUserId())
                .orElseThrow(() -> new DataNotFoundException("User not found"));

        foundBooking.setStatus(booking.getStatus());
        foundBooking.setBookingDate(booking.getBookingDate());
        foundBooking.setSeatCount(booking.getSeatCount());
        foundBooking.setTotalAmount(booking.getTotalAmount());
        foundBooking.setFlightId(foundFlight);
        foundBooking.setUser(foundUser);

    }

    @Override
    public void deleteBooking(String bookingId) {
       bookingDao.findById(bookingId)
                .orElseThrow(() -> new DataNotFoundException("Booking not found"));
     bookingDao.deleteById(bookingId);
    }

    @Override
    public BookingDTO getBooking(String bookingId) {
        var foundBooking = bookingDao.findById(bookingId)
                .orElseThrow(() -> new DataNotFoundException("Booking not found"));
        return objMapper.toBookingDTO(foundBooking);
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return objMapper.toBookingDTOList(bookingDao.findAll());
    }
}
