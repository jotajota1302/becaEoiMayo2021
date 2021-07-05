package com.es.eoi.repositories;

import javax.persistence.EntityManager;

public abstract class AbstractSaveUpdateRemove<E> {
		
	public EntityManager em;
	
	public E save(E entity) {

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
	
	public E update(E entity) {

		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

		return entity;
	}

	public void removeCuenta(E entity) {

		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

}