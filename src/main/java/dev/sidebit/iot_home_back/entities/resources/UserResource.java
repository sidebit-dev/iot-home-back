package dev.sidebit.iot_home_back.entities.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sidebit.iot_home_back.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1,"Miguel","miguel@gmail.com","123456");
		return ResponseEntity.ok().body(u);
	}
}
