package com.atila.desafio_01.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atila.desafio_01.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@GetMapping
	ResponseEntity<List<Client>> findAll(){
		List<Client> list = new ArrayList<>();
		list.add(new Client(1L, "Atila Silva", "12345678912", 5000.0, Instant.parse("1993-12-31T03:50:00Z"), 1));
		list.add(new Client(2L, "João Souza", "12345678912", 6500.0, Instant.parse("1993-12-31T03:50:00Z"), 0));
		return ResponseEntity.ok().body(list);
	}
}
