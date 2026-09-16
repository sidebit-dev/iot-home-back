package dev.sidebit.iot_home_back.repositories;

import dev.sidebit.iot_home_back.entities.Ticket;
import dev.sidebit.iot_home_back.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
