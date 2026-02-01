package lk.ijse.cmjd113.AirTicketCollector.util;

import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.BookingDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.FlightDTO;
import lk.ijse.cmjd113.AirTicketCollector.dto.UserDTO;
import lk.ijse.cmjd113.AirTicketCollector.entities.AirportEntity;
import lk.ijse.cmjd113.AirTicketCollector.entities.BookingEntity;
import lk.ijse.cmjd113.AirTicketCollector.entities.FlightEntity;
import lk.ijse.cmjd113.AirTicketCollector.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ObjMapper {
    private final ModelMapper modelMapper;
    //Airport
    public AirportDTO toAirportDTO(AirportEntity  airportEntity) {
        return modelMapper.map(airportEntity, AirportDTO.class);
    }
    public AirportEntity toAirportEntity(AirportDTO  airportDTO) {
        return modelMapper.map(airportDTO, AirportEntity.class);
    }
    public List<AirportDTO> toAirportDTOList(List<AirportEntity> airportEntityList) {
        return modelMapper.map(airportEntityList,
                new TypeToken<List<AirportDTO>>(){}.getType());
    }
    //Flight
    public FlightDTO toFlightDTO(FlightEntity flightEntity) {
        return modelMapper.map(flightEntity, FlightDTO.class);
    }
    public FlightEntity toFlightEntity(FlightDTO  flightDTO) {
        return modelMapper.map(flightDTO, FlightEntity.class);
    }
    public List<FlightDTO> toFlightDTOList(List<FlightEntity> flightEntityList) {
        return modelMapper.map(flightEntityList,
                new TypeToken<List<FlightDTO>>(){}.getType());
    }
    //User
    public UserDTO toUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public UserEntity toUserEntity(UserDTO  userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public List<UserDTO> toUserDTOList(List<UserEntity> userEntityList) {
        return modelMapper.map(userEntityList,
                new TypeToken<List<UserDTO>>(){}.getType());
    }
    //Booking
    public BookingDTO toBookingDTO(BookingEntity bookingEntity) {
        return modelMapper.map(bookingEntity, BookingDTO.class);
    }
    public BookingEntity toBookingEntity(BookingDTO  bookingDTO) {
        return modelMapper.map(bookingDTO, BookingEntity.class);
    }
    public List<BookingDTO> toBookingDTOList(List<BookingEntity> bookingEntitiyList) {
        return modelMapper.map(bookingEntitiyList,
                new TypeToken<List<BookingDTO>>(){}.getType());
    }

}
