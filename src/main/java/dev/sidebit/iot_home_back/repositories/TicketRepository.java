package dev.sidebit.iot_home_back.repositories;

import dev.sidebit.iot_home_back.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
