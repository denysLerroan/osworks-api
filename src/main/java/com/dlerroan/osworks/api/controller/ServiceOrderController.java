package com.dlerroan.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dlerroan.osworks.api.model.RepresentationServiceOrderModel;
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
	
	@Autowired
	private ModelMapper modelMapper; //Deve ser anotado como um bean para o spring; foi criada a classe ModelMapperConfig no pacote core.
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceOrder insert(@Valid @RequestBody ServiceOrder serviceOrder) {
		return service.insert(serviceOrder);
	}
	
	@GetMapping
	public List<ServiceOrder> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/{serviceOrderId}")
	public ResponseEntity<RepresentationServiceOrderModel> findById(@PathVariable Long serviceOrderId){
		Optional<ServiceOrder> serviceOrder = repository.findById(serviceOrderId);
		
		if(serviceOrder.isPresent()) {
			RepresentationServiceOrderModel model = modelMapper.map(serviceOrder.get(), RepresentationServiceOrderModel.class);
			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.notFound().build();
	}

}
