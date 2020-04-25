package com.dlerroan.osworks.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlerroan.osworks.domain.exception.BusinessException;
import com.dlerroan.osworks.domain.model.Client;
import com.dlerroan.osworks.domain.model.ServiceOrder;
import com.dlerroan.osworks.domain.model.ServiceOrderStatus;
import com.dlerroan.osworks.domain.repository.ClientRepository;
import com.dlerroan.osworks.domain.repository.ServiceOrderRepository;

@Service
public class ManagmentServiceOrderService {
	
	@Autowired
	private ServiceOrderRepository repository;
	
	@Autowired
	private ClientRepository cRepository;
	
	public ServiceOrder insert(ServiceOrder serviceOrder) {
		Client client = cRepository.findById(serviceOrder.getClient().getId())
				.orElseThrow(() -> new BusinessException("Cliente não encontrado"));
		
		serviceOrder.setClient(client);
		serviceOrder.setStatus(ServiceOrderStatus.ABERTA);
		serviceOrder.setOpenedDate(LocalDateTime.now());
		
		return repository.save(serviceOrder);
	}

}
