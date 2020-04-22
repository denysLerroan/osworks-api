package com.dlerroan.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dlerroan.osworks.domain.model.Client;
import com.dlerroan.osworks.domain.repository.ClientRepository;

@RestController
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/clientes")
	public List<Client> list() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Optional<Client> client = clientRepository.findById(id);
		
		if(client.isPresent()) {
			return ResponseEntity.ok(client.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
