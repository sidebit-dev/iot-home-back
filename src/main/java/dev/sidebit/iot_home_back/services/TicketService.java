package dev.sidebit.iot_home_back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sidebit.iot_home_back.entities.Ticket;
import dev.sidebit.iot_home_back.repositories.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository repository;
	
	public List<Ticket> fingAll(){
		return repository.findAll();
	}
	
	public Ticket findyById(Integer id) {
	   Optional<Ticket> obj = repository.findById(id);
	   return obj.get();
	}

}
