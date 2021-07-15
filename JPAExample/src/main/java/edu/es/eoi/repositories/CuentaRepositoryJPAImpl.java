package edu.es.eoi.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.es.eoi.entities.Cuenta;

@Repository
public class CuentaRepositoryJPAImpl extends MyAbstractCRUD<Cuenta, Integer> {

	public Cuenta findCuenta(int id) {

		return em.find(Cuenta.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Cuenta> findAll() {

		String hql = "from Cuenta";
		Query query = em.createQuery(hql);

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Cuenta> findAllByBancoId(int idBanco) {

		String hql = "from Cuenta where Banco.id = :param";
		Query query = em.createQuery(hql);
		query.setParameter("param", idBanco);

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Cuenta> findAllByCliente(String dni) {

		String hql = "from Cuenta c where c.cliente.dni = :param";
		Query query = em.createQuery(hql);
		query.setParameter("param", dni);

		return query.getResultList();

	}

	public Cuenta saveCuenta(Cuenta cuenta) {
		return super.save(cuenta);
	}

	public Cuenta updateCuenta(Cuenta cuenta) {

		return super.update(cuenta);
	}

	public void removeCuenta(Cuenta cuenta) {
		super.remove(cuenta);

	}

}
