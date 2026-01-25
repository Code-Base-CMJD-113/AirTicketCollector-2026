package lk.ijse.cmjd113.AirTicketCollector;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirTicketCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirTicketCollectorApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
