package lk.ijse.cmjd113.AirTicketCollector.dao;

import lk.ijse.cmjd113.AirTicketCollector.entities.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportDao extends JpaRepository<AirportEntity,String> {
}
