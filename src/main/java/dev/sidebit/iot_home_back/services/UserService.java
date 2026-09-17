package dev.sidebit.iot_home_back.services;

import dev.sidebit.iot_home_back.entities.User;
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
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Integer id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Integer id){
        try {
        	if(repository.existsById(id)) {
        		repository.deleteById(id);
        	} else {
        		throw new ResourceNotFoundException(id);
        	}            
//        } catch (EmptyResultDataAccessException e) {
//            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Integer id, User obj){
    	try {
	        User entity = repository.getReferenceById(id);
	        updateData(entity, obj);
	        return repository.save(entity);
    	}catch (EntityNotFoundException e) {
    		throw new ResourceNotFoundException(id);    	          
		}	
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        entity.setActive(obj.getActive());
    }
}
