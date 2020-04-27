package com.dlerroan.osworks.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dlerroan.osworks.api.model.CommentInput;
import com.dlerroan.osworks.api.model.CommentModel;
import com.dlerroan.osworks.domain.model.Comment;
import com.dlerroan.osworks.domain.model.ServiceOrder;
import com.dlerroan.osworks.domain.repository.ServiceOrderRepository;
import com.dlerroan.osworks.domain.service.ManagmentServiceOrderService;

@RestController
@RequestMapping("/ordens-servico/{serviceOrderId}/comentarios")
public class CommentController {
	
	@Autowired
	private ManagmentServiceOrderService service;
	
	@Autowired
	private ServiceOrderRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<CommentModel> findAll(@PathVariable Long serviceOrderId){
		ServiceOrder serviceOrder = repository.findById(serviceOrderId)
				.orElseThrow(() -> new com.dlerroan.osworks.domain.exception.EntityNotFoundException("Ordem de serviço não encontrada"));
		
		return toCollectionModel(serviceOrder.getComments());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CommentModel insert(@PathVariable Long serviceOrderId, 
			@Valid @RequestBody CommentInput commentInput) {
		Comment comment = service.addComment(serviceOrderId, commentInput.getDescription());
		
		return toModel(comment);
	}

	private CommentModel toModel(Comment comment) {
		return modelMapper.map(comment, CommentModel.class);
	}
	
	private List<CommentModel> toCollectionModel(List<Comment> comments) {
		return comments.stream()
				.map(comment -> toModel(comment))
				.collect(Collectors.toList());
	}

}
