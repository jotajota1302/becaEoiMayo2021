package edu.es.eoi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.dtos.ClienteDto;
import edu.es.eoi.entities.Cliente;
import edu.es.eoi.entities.Cuenta;
import edu.es.eoi.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;

	public Cliente saveCliente(Cliente cliente) {

		return this.repository.saveCliente(cliente);

	}

	public Cliente updateCliente(Cliente cliente) {

		return this.repository.updateCliente(cliente);

	}

	public void removeCliente(Cliente cliente) {

		this.repository.removeCliente(cliente);
	}

	public ClienteDto findCliente(String dni) {

		Cliente cliente = this.repository.findCliente(dni);
		
		double saldoTotal=0.0;
		
		for (Cuenta cuenta : cliente.getCuentas()) {
			saldoTotal=saldoTotal+cuenta.getSaldo();
		}	

		cliente.setDni(cliente.getDni().substring(0, 4).concat("####"));

		return ClienteDto.builder()
						 .dni(cliente.getDni())
						 .nombre(cliente.getNombre())
						 .direccion(cliente.getDireccion())
						 .saldoTotal(saldoTotal)
						 .build();
	}

	public List<Cliente> findAll() {

		return this.repository.findAll();

	}

}
