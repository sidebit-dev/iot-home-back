package dev.sidebit.iot_home_back.config;

import dev.sidebit.iot_home_back.entities.Ticket;
import dev.sidebit.iot_home_back.entities.User;
import dev.sidebit.iot_home_back.repositories.TicketRepository;
import dev.sidebit.iot_home_back.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "123456","988888888", true);
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "123456","988888888", true);

        Ticket t1 = new Ticket(null, "Instalação de Sensores IR", "Instalar 4 IR's ativos.", "Rua Ladeira Geral, 345", "PENDENTE", true, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Ticket t2 = new Ticket(null, "Instalação de Sensores IR", "Instalar 4 IR's ativos.", "Rua Ladeira Geral, 345", "PENDENTE", true, Instant.parse("2019-06-20T19:53:07Z"), u2);
        Ticket t3 = new Ticket(null, "Instalação de Sensores IR", "Instalar 4 IR's ativos.", "Rua Ladeira Geral, 345", "PENDENTE", true, Instant.parse("2019-06-20T19:53:07Z"), u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        ticketRepository.saveAll(Arrays.asList(t1, t2, t3));
    }
}
