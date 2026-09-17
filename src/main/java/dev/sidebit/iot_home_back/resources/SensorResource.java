package dev.sidebit.iot_home_back.resources;

import dev.sidebit.iot_home_back.entities.Sensor;
import dev.sidebit.iot_home_back.entities.Ticket;
import dev.sidebit.iot_home_back.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/sensors")
public class SensorResource {

	@Autowired
	private SensorService service;
	
	@GetMapping
	public ResponseEntity<List<Sensor>> findAll(){
		List<Sensor> list;
        list = service.findAll();
        return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Sensor> findById(@PathVariable Integer id){
		Sensor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Sensor> insert(@RequestBody Sensor obj){
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
}
