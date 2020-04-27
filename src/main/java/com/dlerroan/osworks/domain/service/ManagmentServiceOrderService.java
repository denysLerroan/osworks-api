package com.dlerroan.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlerroan.osworks.domain.exception.BusinessException;
import com.dlerroan.osworks.domain.exception.EntityNotFoundException;
import com.dlerroan.osworks.domain.model.Client;
import com.dlerroan.osworks.domain.model.Comment;
import com.dlerroan.osworks.domain.model.ServiceOrder;
import com.dlerroan.osworks.domain.model.ServiceOrderStatus;
import com.dlerroan.osworks.domain.repository.ClientRepository;
import com.dlerroan.osworks.domain.repository.CommentRepository;
import com.dlerroan.osworks.domain.repository.ServiceOrderRepository;

@Service
public class ManagmentServiceOrderService {
	
	@Autowired
	private ServiceOrderRepository repository;
	
	@Autowired
	private ClientRepository cRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	public ServiceOrder insert(ServiceOrder serviceOrder) {
		Client client = cRepository.findById(serviceOrder.getClient().getId())
				.orElseThrow(() -> new BusinessException("Cliente não encontrado"));
		
		serviceOrder.setClient(client);
		serviceOrder.setStatus(ServiceOrderStatus.ABERTA);
		serviceOrder.setOpenedDate(OffsetDateTime.now());
		
		return repository.save(serviceOrder);
	}
	
	public void closeOrder(Long serviceOrderId) {
		ServiceOrder serviceOrder = find(serviceOrderId);
		
		serviceOrder.close();
		
		repository.save(serviceOrder);
	}
	
	public Comment addComment(Long serviceOrderId, String description) {
		ServiceOrder serviceOrder = find(serviceOrderId);
		
		Comment comment = new Comment();
		comment.setSendDate(OffsetDateTime.now());
		comment.setDescription(description);
		comment.setServiceOrder(serviceOrder);
		
		return commentRepository.save(comment);
	}
	
	private ServiceOrder find(Long serviceOrderId) {
		return repository.findById(serviceOrderId)
				.orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não encontrada"));
	}

}
