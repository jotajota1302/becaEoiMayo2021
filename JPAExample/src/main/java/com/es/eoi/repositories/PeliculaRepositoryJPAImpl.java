package com.es.eoi.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.es.eoi.entities.Pelicula;

public class PeliculaRepositoryJPAImpl {

	public EntityManager em;

	// CONSTRUCTOR
	public PeliculaRepositoryJPAImpl() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		em = factory.createEntityManager();
	}

	public Pelicula savePelicula(Pelicula pelicula) {
		
		//la guardas 
		
		return pelicula;
	}
	
	public Pelicula updatePelicula(Pelicula pelicula) {
		
		//la updateas 
		
		return pelicula;
	}
	
	public void removePelicula(Pelicula pelicula) {
		
		//la borras 
		
		
	}
	
	public Pelicula findPelicula(int id) {
		
		//la encuentras 
		
		return null;
	}
	
}
