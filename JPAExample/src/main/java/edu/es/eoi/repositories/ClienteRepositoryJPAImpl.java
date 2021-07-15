package edu.es.eoi.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.es.eoi.entities.Cliente;

@Repository
public class ClienteRepositoryJPAImpl extends MyAbstractCRUD<Cliente, String> {
	
	public Cliente findCliente(String dni) {

		return em.find(Cliente.class, dni);

	}


	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {

		String hql = "from Cliente";
		Query query = em.createQuery(hql);

		return query.getResultList();

	}

	
	public Cliente saveCliente(Cliente cliente) {
		return super.save(cliente);
	}

	
	public Cliente updateCliente(Cliente cliente) {
	return super.update(cliente);
	}

	
	public void removeCliente(Cliente cliente) {
		super.remove(cliente);
		
	}

}
