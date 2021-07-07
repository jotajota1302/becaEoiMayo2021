package edu.es.eoi.flixnet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.Pelicula;

public class PeliculaRepositoryJPAImpl implements PeliculaRepository {
	
public EntityManager em;
	
	public PeliculaRepositoryJPAImpl() {		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PeliculasPersistenceUnit");
		em = factory.createEntityManager();
	}
	
	public Pelicula save(Pelicula entity) {

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

	public Pelicula update(Pelicula entity) {

		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

		return entity;
	}

	public void remove(Pelicula entity) {

		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public Pelicula find(int id) {

		return em.find(Pelicula.class,id);
	}
	
	@Override
	public List<Pelicula> buscarPorActor(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> buscarPorGenero(String genero) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
