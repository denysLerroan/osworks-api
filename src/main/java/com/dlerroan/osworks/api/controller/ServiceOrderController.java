package com.dlerroan.osworks.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dlerroan.osworks.domain.model.ServiceOrder;
import com.dlerroan.osworks.domain.repository.ServiceOrderRepository;
import com.dlerroan.osworks.domain.service.ManagmentServiceOrderService;

@RestController
@RequestMapping("/ordens-servico")
public class ServiceOrderController {
	
	@Autowired
	private ManagmentServiceOrderService service;
	
	@Autowired
	private ServiceOrderRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceOrder insert(@Valid @RequestBody ServiceOrder serviceOrder) {
		return service.insert(serviceOrder);
	}
	
	@GetMapping
	public List<ServiceOrder> list(){
		return repository.findAll();
	}

}
