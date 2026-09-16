package dev.sidebit.iot_home_back.services;

import dev.sidebit.iot_home_back.entities.Ticket;
import dev.sidebit.iot_home_back.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return obj.get();
    }
}
