package com.atila.desafio_01.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atila.desafio_01.entities.Client;
import com.atila.desafio_01.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	ResponseEntity<List<Client>> findAll(){
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
