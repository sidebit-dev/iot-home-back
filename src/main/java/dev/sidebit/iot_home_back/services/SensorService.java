package dev.sidebit.iot_home_back.services;

import dev.sidebit.iot_home_back.entities.Sensor;
import dev.sidebit.iot_home_back.repositories.SensorRepository;
import dev.sidebit.iot_home_back.services.exceptions.DatabaseException;
import dev.sidebit.iot_home_back.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Sensor insert(Sensor obj){
        return repository.save(obj);
    }

    public void delete(Integer id){
        try {
            if(repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Sensor update(Integer id, Sensor obj){
        try {
            Sensor entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Sensor entity, Sensor obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setSensorStatus(obj.getSensorStatus());
        entity.setActive(obj.getActive());
        entity.setMoment(obj.getMoment());
    }
}
