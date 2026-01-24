package lk.ijse.cmjd113.AirTicketCollector.service;

import lk.ijse.cmjd113.AirTicketCollector.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    void saveBooking(BookingDTO bookingId);
    void updateBooking(String bookingId,BookingDTO booking);
    void deleteBooking(String bookingId);
    BookingDTO getBooking(String bookingId);
    List<BookingDTO> getAllBookings();
}
