package dev.sidebit.iot_home_back.resources;

import dev.sidebit.iot_home_back.entities.Sensor;
import dev.sidebit.iot_home_back.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
