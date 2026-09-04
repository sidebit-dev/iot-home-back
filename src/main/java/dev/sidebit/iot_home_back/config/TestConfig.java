package dev.sidebit.iot_home_back.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import dev.sidebit.iot_home_back.entities.Ticket;
import dev.sidebit.iot_home_back.entities.User;
import dev.sidebit.iot_home_back.repositories.TicketRepository;
import dev.sidebit.iot_home_back.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Miguel", "miguel@gmail.com", "123456", "11993456534");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "123456", "11993456534");
		User u3 = new User(null, "Alex Green", "alex@gmail.com", "123456", "11993456534");
		
		Ticket t1 = new Ticket(null, "Proteção Perimetral", "Instalação de 4 sensores IR", 
				"Rua do Sobe e Desce, 45 - Centro - Santos", Instant.parse("2026-08-20T08:00:00Z"),u2);
		Ticket t2 = new Ticket(null, "Proteção Perimetral", "Instalação de 4 sensores IR", 
				"Rua Ladeira Geral, 80 - Centro - Santos", Instant.parse("2026-08-20T08:00:00Z"),u3);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		ticketRepository.saveAll(Arrays.asList(t1, t2));		
	}
}
