package dev.sidebit.iot_home_back.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sidebit.iot_home_back.entities.Ticket;
import dev.sidebit.iot_home_back.services.TicketService;

@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {
	
	@Autowired
	private TicketService service;

	@GetMapping
	public ResponseEntity<List<Ticket>> findAll(){
		List<Ticket> list = service.fingAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ticket> findById(@PathVariable Integer id){
		Ticket obj = service.findyById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
