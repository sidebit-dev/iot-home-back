package dev.sidebit.iot_home_back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sidebit.iot_home_back.entities.Sensor;
import dev.sidebit.iot_home_back.entities.Ticket;
import dev.sidebit.iot_home_back.repositories.SensorRepository;

@Service
public class SensorService {
	
	@Autowired
	private SensorRepository repository;
	
	public List<Sensor> fingAll(){
		return repository.findAll();
	}
	
	public Sensor findyById(Integer id) {
	   Optional<Sensor> obj = repository.findById(id);
	   return obj.get();
	}

}
