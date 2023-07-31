package com.desafios.desafioCRUD.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafios.desafioCRUD.dto.ClientDTO;
import com.desafios.desafioCRUD.entities.Client;
import com.desafios.desafioCRUD.repositories.ClientRepository;
import com.desafios.desafioCRUD.services.exceptions.DatabaseException;
import com.desafios.desafioCRUD.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client cli = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not founded"));
		return new ClientDTO(cli);
	}
	
	@Transactional(readOnly = true)
	public Page <ClientDTO> findAll(Pageable pageable) {
		Page<Client> result = repository.findAll(pageable);
		return result.map(x -> new ClientDTO(x));
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ClientDTO(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Client not found");
		}
		
	}

	@Transactional
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Client not found");
		}
		 try {
			 repository.deleteById(id);
		 }
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("referential integrity failure");
		}
	}
	
	private void copyDtoToEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}
	
}
