package com.es.eoi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.es.eoi.entities.Cliente;

public class ClienteRepositoryJPAImpl {

	public EntityManager em;

	public ClienteRepositoryJPAImpl() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BancoPersistenceUnit");
		em = factory.createEntityManager();
	}

	public Cliente saveCliente(Cliente cliente) {

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

	public Cliente updateCliente(Cliente cliente) {

		try {
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

		return cliente;
	}

	public void removeCliente(Cliente cliente) {

		try {
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public Cliente findCliente(String dni) {

		return em.find(Cliente.class, dni);

	}

	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {

		String hql = "from Cliente";
		Query query = em.createQuery(hql);

		return query.getResultList();

	}

}
