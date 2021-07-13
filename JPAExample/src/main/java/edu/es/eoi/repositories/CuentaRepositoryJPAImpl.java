package edu.es.eoi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.es.eoi.entities.Cuenta;

@Repository	
public class CuentaRepositoryJPAImpl implements CuentaRepository {

	@Autowired 	
	public EntityManager em;	
	
	@Override
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

	@Override
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

	@Override
	public void removeCuenta(Cuenta cuenta) {

		try {
			em.getTransaction().begin();
			em.remove(cuenta);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public Cuenta findCuenta(int id) {

		return em.find(Cuenta.class, id);

	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cuenta> findAll(){
		
		String hql = "from Cuenta";
		Query query = em.createQuery(hql);		

		return query.getResultList();		
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cuenta> findAllByBancoId(int idBanco){
		
		String hql = "from Cuenta where Banco.id = :param";
		Query query = em.createQuery(hql);
		query.setParameter("param", idBanco);

		return query.getResultList();		
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cuenta> findAllByCliente(String dni){
		
		String hql = "from Cuenta c where c.cliente.dni = :param";
		Query query = em.createQuery(hql);
		query.setParameter("param", dni);

		return query.getResultList();		
		
	}
	
	

}
