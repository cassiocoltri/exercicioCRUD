package com.desafios.desafioCRUD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafios.desafioCRUD.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
