package com.desafios.desafioCRUD.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafios.desafioCRUD.entities.Client;
import com.desafios.desafioCRUD.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Optional<Client> findById(Long id) {
		Optional<Client> client = repository.findById(id);
		return client;
	}
	
	@Transactional(readOnly = true)
	public Page <Client> findAll(Pageable pageable) {
		Page<Client> result = repository.findAll(pageable);
		return result;
	}
}
