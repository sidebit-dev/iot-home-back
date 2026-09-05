package dev.sidebit.iot_home_back.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sidebit.iot_home_back.entities.Sensor;
import dev.sidebit.iot_home_back.entities.Ticket;
import dev.sidebit.iot_home_back.services.SensorService;

@RestController
@RequestMapping(value = "/sensors")
public class SensorResource {
	
	@Autowired
	private SensorService service;

	@GetMapping
	public ResponseEntity<List<Sensor>> findAll(){
		List<Sensor> list = service.fingAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Sensor> findById(@PathVariable Integer id){
		Sensor obj = service.findyById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
