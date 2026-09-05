package dev.sidebit.iot_home_back.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import dev.sidebit.iot_home_back.entities.Sensor;
import dev.sidebit.iot_home_back.entities.Ticket;
import dev.sidebit.iot_home_back.entities.User;
import dev.sidebit.iot_home_back.entities.enums.SensorStatus;
import dev.sidebit.iot_home_back.entities.enums.TicketStatus;
import dev.sidebit.iot_home_back.entities.enums.UserRole;
import dev.sidebit.iot_home_back.repositories.SensorRepository;
import dev.sidebit.iot_home_back.repositories.TicketRepository;
import dev.sidebit.iot_home_back.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private SensorRepository sensorRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Miguel", "miguel@gmail.com", "123456", "11993456534",UserRole.ADMIN);
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "123456", "11993456534", UserRole.CLIENTE);
		User u3 = new User(null, "Alex Green", "alex@gmail.com", "123456", "11993456534", UserRole.CLIENTE);
		
		Ticket t1 = new Ticket(null, "Proteção Perimetral", "Instalação de 4 sensores IR", 
				"Rua do Sobe e Desce, 45 - Centro - Santos", Instant.parse("2026-08-20T08:00:00Z"),TicketStatus.PENDENTE,u2);
		Ticket t2 = new Ticket(null, "Proteção Perimetral", "Instalação de 4 sensores IR", 
				"Rua Ladeira Geral, 80 - Centro - Santos", Instant.parse("2026-08-20T08:00:00Z"), TicketStatus.ANDAMENTO,u3);
		
		Sensor s1 = new Sensor(null, "IRSF", "Sensor lado FRENTE", SensorStatus.ALARME, 
				Instant.parse("2026-08-20T08:00:00Z"), t1);
		Sensor s2 = new Sensor(null, "IRSD", "Sensor lado DIREITO", SensorStatus.NORMAL, 
				Instant.parse("2026-08-20T08:00:00Z"), t1);
		Sensor s3 = new Sensor(null, "IRSE", "Sensor lado ESQUERDO", SensorStatus.NORMAL, 
				Instant.parse("2026-08-20T08:00:00Z"), t1);
		Sensor s4 = new Sensor(null, "IRST", "Sensor lado TRAS", SensorStatus.ALARME, 
				Instant.parse("2026-08-20T08:00:00Z"), t1);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		ticketRepository.saveAll(Arrays.asList(t1, t2));
		sensorRepository.saveAll(Arrays.asList(s1, s2, s3, s4));
	}
}
