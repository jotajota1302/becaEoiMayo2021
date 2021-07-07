package edu.es.eoi.flixnet.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.es.eoi.flixnet.entities.Categoria;

public class CategoriaRepositoryJPAImpl {
		
	public EntityManager em;
	
	public CategoriaRepositoryJPAImpl() {		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PeliculasPersistenceUnit");
		em = factory.createEntityManager();
	}
	
	public Categoria save(Categoria entity) {

		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return entity;
	}

	public Categoria update(Categoria entity) {

		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

		return entity;
	}

	public void remove(Categoria entity) {

		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public Categoria find(int id) {

		return em.find(Categoria.class,id);
	}
}
