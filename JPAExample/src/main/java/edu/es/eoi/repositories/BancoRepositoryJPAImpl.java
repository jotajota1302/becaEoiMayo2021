package edu.es.eoi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.es.eoi.entities.Banco;

public class BancoRepositoryJPAImpl {

	public EntityManager em;

	public BancoRepositoryJPAImpl() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BancoPersistenceUnit");
		em = factory.createEntityManager();
	}

	public Banco saveBanco(Banco cliente) {

		try {
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return cliente;
	}

	public Banco updateBanco(Banco cliente) {

		try {
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

		return cliente;
	}

	public void removeBanco(Banco cliente) {

		try {
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public Banco findBanco(int id) {

		return em.find(Banco.class, id);

	}
	
	@SuppressWarnings("unchecked")
	public List<Banco> findAll() {

		String hql = "from Banco";
		Query query = em.createQuery(hql);

		return query.getResultList();

	}
	

}
