package lk.ijse.cmjd113.AirTicketCollector.controller;


import lk.ijse.cmjd113.AirTicketCollector.dto.BookingDTO;
import lk.ijse.cmjd113.AirTicketCollector.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingDataController {

  private final BookingService bookingService;

  @GetMapping("/{bookingId}")
  public ResponseEntity<BookingDTO>getBooking(@PathVariable String bookingId) {
    return new ResponseEntity<>(bookingService.getBooking(bookingId), HttpStatus.OK);
  }
  @PostMapping
  public ResponseEntity<Void>addBooking(@RequestBody BookingDTO booking) {
    bookingService.saveBooking(booking);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
  @GetMapping
  public  ResponseEntity<List<BookingDTO>> getAllBookings(){
    return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
  }
  @DeleteMapping("/{bookingId}")
  public ResponseEntity<Void> deleteBooking(@PathVariable String bookingId) {
    bookingService.deleteBooking(bookingId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  @PatchMapping("/{bookingId}")
  public ResponseEntity<Void> updateAirport(@PathVariable String bookingId,@RequestBody BookingDTO bookingData){
    bookingService.updateBooking(bookingId, bookingData);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
