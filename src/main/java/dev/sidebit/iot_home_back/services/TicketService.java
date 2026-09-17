package dev.sidebit.iot_home_back.services;

import dev.sidebit.iot_home_back.entities.Sensor;
import dev.sidebit.iot_home_back.entities.Ticket;
import dev.sidebit.iot_home_back.entities.User;
import dev.sidebit.iot_home_back.repositories.TicketRepository;
import dev.sidebit.iot_home_back.repositories.UserRepository;
import dev.sidebit.iot_home_back.services.exceptions.DatabaseException;
import dev.sidebit.iot_home_back.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    public List<Ticket> findAll(){
        return repository.findAll();
    }

    public Ticket findById(Integer id){
        Optional<Ticket> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Ticket insert(Ticket obj){
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

    public Ticket update(Integer id, Ticket obj){
        try {
            Ticket entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Ticket entity, Ticket obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setAddress(obj.getAddress());
        entity.setTicketStatus(obj.getTicketStatus());
        entity.setActive(obj.getActive());
        entity.setClient(obj.getClient());
    }
}
