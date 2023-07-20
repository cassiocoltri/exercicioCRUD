package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
