package edu.es.eoi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.eoi.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,String> {
	
	public List<Cliente> findByNombreStartingWith(String nombre);

}
