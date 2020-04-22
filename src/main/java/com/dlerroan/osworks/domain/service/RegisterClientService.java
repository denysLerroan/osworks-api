package com.dlerroan.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlerroan.osworks.domain.exception.BusinessException;
import com.dlerroan.osworks.domain.model.Client;
import com.dlerroan.osworks.domain.repository.ClientRepository;

@Service
public class RegisterClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public Client insert (Client client) {
		Client existingClient = clientRepository.findByEmail(client.getEmail());
		
		if(existingClient != null && !existingClient.equals(client)) {
			throw new BusinessException("Já existe um cliente cadastrado com este e-mail.");
		}
		
		return clientRepository.save(client);
	}
	
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
}
