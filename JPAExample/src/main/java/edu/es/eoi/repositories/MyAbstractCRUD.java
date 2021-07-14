package edu.es.eoi.repositories;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class MyAbstractCRUD<C,PK> {
	
	@Autowired
	@Qualifier("myEM")
	public EntityManager em;
	
	public C save(C entity) {

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
	
	public C update(C entity) {

		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

		return entity;
	}
	
	public void remove(C entity) {

		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

}