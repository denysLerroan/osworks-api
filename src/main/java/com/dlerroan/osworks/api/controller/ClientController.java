package com.dlerroan.osworks.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlerroan.osworks.domain.model.Client;

@RestController
public class ClientController {
	
	@PersistenceContext
	private EntityManager manager; // Responsavel por buscar no banco de dados
	
	@GetMapping("/clientes")
	public List<Client> list() {
		return manager.createQuery("from Client", Client.class).getResultList();
	}

}
