package edu.es.eoi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.es.eoi.entities.Banco;

@Repository
public class BancoRepositoryJPAImpl implements BancoRepository {

	@Autowired
	public EntityManager em;

	@Override
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

	@Override
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

	@Override
	public void removeBanco(Banco cliente) {

		try {
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public Banco findBanco(int id) {

		return em.find(Banco.class, id);

	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Banco> findAll() {

		String hql = "from Banco";
		Query query = em.createQuery(hql);

		return query.getResultList();

	}
	

}
