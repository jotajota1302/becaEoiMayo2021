package edu.es.eoi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.es.eoi.entities.Banco;

@Repository
public class BancoRepositoryJPAImpl implements BancoRepository {

	@Autowired
	@Qualifier("myEM")
	public EntityManager em;

	@Override
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

	@Override
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

	@Override
	public void removeBanco(Banco banco) {

		try {
			em.getTransaction().begin();
			em.remove(banco);
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
