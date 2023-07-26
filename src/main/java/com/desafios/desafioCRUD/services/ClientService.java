package com.desafios.desafioCRUD.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafios.desafioCRUD.dto.ClientDTO;
import com.desafios.desafioCRUD.entities.Client;
import com.desafios.desafioCRUD.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client cli = repository.findById(id).get();
		return new ClientDTO(cli);
	}
	
	@Transactional(readOnly = true)
	public Page <ClientDTO> findAll(Pageable pageable) {
		Page<Client> result = repository.findAll(pageable);
		return result.map(x -> new ClientDTO(x));
	}
}
