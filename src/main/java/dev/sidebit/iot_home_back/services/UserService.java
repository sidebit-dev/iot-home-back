package dev.sidebit.iot_home_back.services;

import dev.sidebit.iot_home_back.entities.User;
import dev.sidebit.iot_home_back.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Integer id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
}
