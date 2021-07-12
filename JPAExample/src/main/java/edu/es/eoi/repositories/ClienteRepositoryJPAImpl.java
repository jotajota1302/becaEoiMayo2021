package edu.es.eoi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.es.eoi.entities.Cliente;


@Repository
public class ClienteRepositoryJPAImpl implements ClienteRepository {
	
	@Autowired
	public EntityManager em;
	
	@Override
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

	@Override
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

	@Override
	public void removeCliente(Cliente cliente) {

		try {
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public Cliente findCliente(String dni) {

		return em.find(Cliente.class, dni);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {

		String hql = "from Cliente";
		Query query = em.createQuery(hql);

		return query.getResultList();

	}

}
