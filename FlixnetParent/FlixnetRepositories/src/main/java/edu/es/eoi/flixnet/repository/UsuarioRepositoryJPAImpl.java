package edu.es.eoi.flixnet.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.es.eoi.flixnet.entities.Usuario;

public class UsuarioRepositoryJPAImpl extends AbstractCRUDRepository<Usuario,Integer> {
		
	public UsuarioRepositoryJPAImpl() {		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PeliculasPersistenceUnit");
		super.em = factory.createEntityManager();
		super.setType(Usuario.class);
	}
	
}
