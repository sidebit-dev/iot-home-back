package dev.sidebit.iot_home_back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sidebit.iot_home_back.entities.User;
import dev.sidebit.iot_home_back.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> fingAll(){
		return repository.findAll();
	}
	
	public User findyById(Integer id) {
	   Optional<User> obj = repository.findById(id);
	   return obj.get();
	}

}
