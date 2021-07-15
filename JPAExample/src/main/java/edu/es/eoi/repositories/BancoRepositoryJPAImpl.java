package edu.es.eoi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.es.eoi.entities.Banco;

@Repository
public class BancoRepositoryJPAImpl {

	@Autowired
	@Qualifier("myEM")
	public EntityManager em;

	
	public Banco saveBanco(Banco banco) {

		try {
			em.getTransaction().begin();
			em.persist(banco);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return banco;
	}

	
	public Banco updateBanco(Banco banco) {

		try {
			em.getTransaction().begin();
			em.merge(banco);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

		return banco;
	}


	public void removeBanco(Banco banco) {

		try {
			em.getTransaction().begin();
			em.remove(banco);
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
