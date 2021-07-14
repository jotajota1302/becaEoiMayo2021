package edu.es.eoi.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
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

	@Autowired
	ModelMapper mapper;

	public ClienteDto saveCliente(ClienteDto cliente) {
		
		this.repository.save(mapper.map(cliente, Cliente.class));

		return cliente;

	}

	public ClienteDto updateCliente(ClienteDto cliente) {

		this.repository.save(mapper.map(cliente, Cliente.class));

		return cliente;

	}

	public void removeCliente(ClienteDto cliente) {

		this.repository.delete(mapper.map(cliente, Cliente.class));
	}

	public ClienteDto findCliente(String dni) {

		Cliente cliente = this.repository.findById(dni).get();

		double saldoTotal = 0.0;

		if (cliente != null) {

			for (Cuenta cuenta : cliente.getCuentas()) {
				saldoTotal = saldoTotal + cuenta.getSaldo();
				ClienteDto dto = mapper.map(cliente, ClienteDto.class);
				dto.setSaldoTotal(saldoTotal);
				return dto;
			}

		}

		return null;
	
	}

	public List<ClienteDto> findAll() {

		List<ClienteDto> result = new ArrayList<ClienteDto>();

		for (Cliente temp : this.repository.findAll()) {
			result.add(mapper.map(temp, ClienteDto.class));
		}

		return result;

	}

}
