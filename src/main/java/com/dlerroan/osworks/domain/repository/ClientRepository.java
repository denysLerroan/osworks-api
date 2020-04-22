package com.dlerroan.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlerroan.osworks.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
