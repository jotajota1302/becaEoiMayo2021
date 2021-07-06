package edu.es.eoi.flixnet.repository;

import javax.persistence.EntityManager;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractCRUDRepository<E, PK> {

	public EntityManager em;
	
	private Class<E> type;

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

	public void remove(E entity) {

		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public E find(PK pk) {

		return em.find(this.getType(),pk);
	}

}