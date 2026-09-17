package dev.sidebit.iot_home_back.resources;

import dev.sidebit.iot_home_back.entities.Ticket;
import dev.sidebit.iot_home_back.entities.User;
import dev.sidebit.iot_home_back.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {

	@Autowired
	private TicketService service;
	
	@GetMapping
	public ResponseEntity<List<Ticket>> findAll(){
		List<Ticket> list;
        list = service.findAll();
        return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Ticket> findById(@PathVariable Integer id){
		Ticket obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Ticket> insert(@RequestBody Ticket obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Ticket> update(@PathVariable Integer id, @RequestBody Ticket obj){
		obj= service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
