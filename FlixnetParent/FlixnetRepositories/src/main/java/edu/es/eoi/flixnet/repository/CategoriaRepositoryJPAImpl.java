package edu.es.eoi.flixnet.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.es.eoi.flixnet.entities.Categoria;

public class CategoriaRepositoryJPAImpl extends AbstractCRUDRepository<Categoria,Integer> {
		
	public CategoriaRepositoryJPAImpl() {		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PeliculasPersistenceUnit");
		super.em = factory.createEntityManager();
		super.setType(Categoria.class);
	}
}
