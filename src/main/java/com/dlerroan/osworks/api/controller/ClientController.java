package com.dlerroan.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlerroan.osworks.domain.model.Client;

@RestController
public class ClientController {
	
	@GetMapping("/clientes")
	public List<Client> list() {
		var c1 = new Client();
		c1.setId(1L);
		c1.setName("João");
		c1.setEmail("joao@gmail.com");
		c1.setPhone("11 99999-8877");
		
		var c2 = new Client();
		c2.setId(2L);
		c2.setName("Maria");
		c2.setEmail("maria@gmail.com");
		c2.setPhone("11 99988-6644");
		return Arrays.asList(c1, c2);
	}

}
