package edu.es.eoi.repositories;

import java.util.List;

import edu.es.eoi.entities.Cliente;

public interface ClienteRepository {

	Cliente saveCliente(Cliente cliente);

	Cliente updateCliente(Cliente cliente);

	void removeCliente(Cliente cliente);

	Cliente findCliente(String dni);

	List<Cliente> findAll();

}