package dev.sidebit.iot_home_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sidebit.iot_home_back.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
