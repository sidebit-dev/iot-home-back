package dev.sidebit.iot_home_back.services;

import dev.sidebit.iot_home_back.entities.Sensor;
import dev.sidebit.iot_home_back.repositories.SensorRepository;
import dev.sidebit.iot_home_back.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository repository;

    public List<Sensor> findAll(){
        return repository.findAll();
    }

    public Sensor findById(Integer id){
        Optional<Sensor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
