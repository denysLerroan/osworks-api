package com.dlerroan.osworks.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlerroan.osworks.domain.model.Client;
import com.dlerroan.osworks.domain.repository.ClientRepository;

@RestController
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/clientes")
	public List<Client> list() {
		//return clientRepository.findAll();
		//return clientRepository.findByName("João da Silva");
		return clientRepository.findByNameContaining("a");
	}
	
}
