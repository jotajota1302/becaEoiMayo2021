package edu.es.eoi.flixnetspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.eoi.flixnetspring.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	
	public Persona findByNombre(String nombre);	

}
