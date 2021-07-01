package com.es.eoi.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.es.eoi.entities.Pelicula;

public class PeliculaRepositoryJPAImpl {

	public EntityManager em;

	public PeliculaRepositoryJPAImpl() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PeliculasPersistenceUnit");
		em = factory.createEntityManager();
	}

	public Pelicula savePelicula(Pelicula pelicula) {

		try {
			em.getTransaction().begin();
			em.persist(pelicula);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return pelicula;
	}

	public Pelicula updatePelicula(Pelicula pelicula) {

		try {		
			em.getTransaction().begin();
			em.merge(pelicula);
			em.getTransaction().commit();		
		} catch (Exception e) {
			em.getTransaction().rollback();			
		}
		
		return pelicula;
	}

	public void removePelicula(Pelicula pelicula) {

		try {		
			em.getTransaction().begin();
			em.remove(pelicula);
			em.getTransaction().commit();			
		} catch (Exception e) {
			em.getTransaction().rollback();		
		}
	}

	public Pelicula findPelicula(int id) {

		return em.find(Pelicula.class, id);

	}

}
