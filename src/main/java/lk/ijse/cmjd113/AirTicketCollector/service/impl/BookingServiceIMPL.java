package lk.ijse.cmjd113.AirTicketCollector.service.impl;

import lk.ijse.cmjd113.AirTicketCollector.dto.BookingDTO;
import lk.ijse.cmjd113.AirTicketCollector.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceIMPL implements BookingService {
    @Override
    public void saveBooking(BookingDTO bookingId) {

    }

    @Override
    public void updateBooking(String bookingId, BookingDTO booking) {

    }

    @Override
    public void deleteBooking(String bookingId) {

    }

    @Override
    public BookingDTO getBooking(String bookingId) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return List.of();
    }
}
