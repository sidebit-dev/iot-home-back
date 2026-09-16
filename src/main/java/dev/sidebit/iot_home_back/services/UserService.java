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
        return  obj.get();
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public User update(Integer id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        entity.setActive(obj.getActive());
    }
}
