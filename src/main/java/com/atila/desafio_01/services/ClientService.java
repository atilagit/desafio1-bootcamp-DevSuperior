package com.atila.desafio_01.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atila.desafio_01.dto.ClientDTO;
import com.atila.desafio_01.entities.Client;
import com.atila.desafio_01.repositories.ClientRepository;
import com.atila.desafio_01.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		return list.stream().map(cli -> new ClientDTO(cli)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client(null, dto.getName(), dto.getCpf(), dto.getImcome(), dto.getBirthDate(), dto.getChildren());
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
}
