package com.dlerroan.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dlerroan.osworks.domain.model.Client;
import com.dlerroan.osworks.domain.repository.ClientRepository;
import com.dlerroan.osworks.domain.service.RegisterClientService;

@RestController
@RequestMapping("/clientes")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private RegisterClientService service;
	
	@GetMapping
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Optional<Client> client = clientRepository.findById(id);
		
		if(client.isPresent()) {
			return ResponseEntity.ok(client.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client insert(@Valid @RequestBody Client client) {
		return service.insert(client);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@Valid @PathVariable Long id, @RequestBody Client client){
		if(!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(id);
		client = service.insert(client);
		
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		if(!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
