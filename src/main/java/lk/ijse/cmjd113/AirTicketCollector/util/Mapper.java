package lk.ijse.cmjd113.AirTicketCollector.util;

import lk.ijse.cmjd113.AirTicketCollector.dto.AirportDTO;
import lk.ijse.cmjd113.AirTicketCollector.entities.AirportEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Mapper {
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

}
