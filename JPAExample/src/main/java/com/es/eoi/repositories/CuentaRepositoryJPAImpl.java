package com.es.eoi.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.es.eoi.entities.Cuenta;

public class CuentaRepositoryJPAImpl {

	public EntityManager em;

	public CuentaRepositoryJPAImpl() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BancoPersistenceUnit");
		em = factory.createEntityManager();
	}

	public Cuenta saveCuenta(Cuenta cuenta) {

		try {
			em.getTransaction().begin();
			em.persist(cuenta);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return cuenta;
	}

	public Cuenta updateCuenta(Cuenta cuenta) {

		try {
			em.getTransaction().begin();
			em.merge(cuenta);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

		return cuenta;
	}

	public void removeCuenta(Cuenta cuenta) {

		try {
			em.getTransaction().begin();
			em.remove(cuenta);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public Cuenta findCuenta(int id) {

		return em.find(Cuenta.class, id);

	}

	

}
