package com.es.eoi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.es.eoi.entities.Cuenta;

public class CuentaRepositoryJPAImpl extends AbstractSaveUpdateRemove<Cuenta> {

	public EntityManager em;

	public CuentaRepositoryJPAImpl() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BancoPersistenceUnit");
		em = factory.createEntityManager();
	}	

	public Cuenta findCuenta(int id) {

		return em.find(Cuenta.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Cuenta> findAllByBancoId(int idBanco){
		
		String hql = "from Cuenta where Banco.id = :param";
		Query query = em.createQuery(hql);
		query.setParameter("param", idBanco);

		return query.getResultList();		
		
	}

}
