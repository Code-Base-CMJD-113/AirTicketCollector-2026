package lk.ijse.cmjd113.AirTicketCollector.dao;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.AirTicketCollector.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDao extends JpaRepository<FlightEntity,String> {
    @Query("SELECT f.availableSeats FROM FlightEntity f WHERE f.flightNo = :flightId")
    int getAvailableSeats(@Param("flightId") String flightId);

    @Modifying
    @Transactional
    @Query("UPDATE FlightEntity f SET f.availableSeats = f.availableSeats - :seatCount WHERE f.flightNo = :flightId")
    int deductAvlSeats(int seatCount,String flightId);

    @Modifying
    @Transactional
    @Query("UPDATE FlightEntity f SET f.availableSeats = f.availableSeats + :seatCount WHERE f.flightNo = :flightId")
    int addAvlSeats(int seatCount,String flightId);
}
