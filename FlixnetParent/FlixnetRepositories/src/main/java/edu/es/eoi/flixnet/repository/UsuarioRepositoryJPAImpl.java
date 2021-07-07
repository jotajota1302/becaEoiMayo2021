package edu.es.eoi.flixnet.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.es.eoi.flixnet.entities.Usuario;

public class UsuarioRepositoryJPAImpl {
		
	public EntityManager em;
	
	public UsuarioRepositoryJPAImpl() {		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PeliculasPersistenceUnit");
		em = factory.createEntityManager();
	}
	
	public Usuario save(Usuario entity) {

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

	public Usuario update(Usuario entity) {

		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

		return entity;
	}

	public void remove(Usuario entity) {

		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public Usuario find(int id) {

		return em.find(Usuario.class,id);
	}
	
	public Usuario find(String user) {

			String hql = "from Usuario u where u.usuario=:user";			
			Query query = em.createQuery(hql);
			query.setParameter("user", user);
		
		return (Usuario) query.getResultList().get(0);
	}
	
}
