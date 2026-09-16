package dev.sidebit.iot_home_back.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sidebit.iot_home_back.entities.User;

@RestController
@RequestMapping(value = "/")
public class SkynetResource {
	
	private String sky = "Se você estiver vendo esta mensagem agora, você faz parte da resistência...";
	
	@GetMapping
	public ResponseEntity<String> findAll(){
		
		return ResponseEntity.ok().body("A Skynet não nos achou "+sky);
	}

}
