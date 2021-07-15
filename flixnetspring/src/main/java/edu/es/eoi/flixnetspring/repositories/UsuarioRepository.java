package edu.es.eoi.flixnetspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.eoi.flixnetspring.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

	public Usuario findByUser(String user);
	
}
