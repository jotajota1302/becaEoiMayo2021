package edu.es.eoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.entities.Cliente;
import edu.es.eoi.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	public Cliente saveCliente(Cliente cliente) {
		
	 return	this.repository.saveCliente(cliente);
		
	}
	
	public Cliente updateCliente(Cliente cliente) {
		
		return this.repository.updateCliente(cliente);
		
	}

	public void removeCliente(Cliente cliente) {
		
		this.repository.removeCliente(cliente);
	}

	public Cliente findCliente(String dni) {
		
		return this.repository.findCliente(dni);
		
	}

	public List<Cliente> findAll(){
		
		return this.repository.findAll();
		
	}

}
