package edu.es.eoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.entities.Cuenta;
import edu.es.eoi.repositories.CuentaRepository;

@Service
public class CuentaService {
	
	@Autowired
	private CuentaRepository repository;
		
	public Cuenta saveCuenta(Cuenta cuenta) {

			return this.repository.saveCuenta(cuenta);
	}

	
	public Cuenta updateCuenta(Cuenta cuenta) {
		
		return this.repository.updateCuenta(cuenta);
	}


	public void removeCuenta(Cuenta cuenta) {

		this.repository.removeCuenta(cuenta);
		
	}

	
	public Cuenta findCuenta(int id) {

		return this.repository.findCuenta(id);

	}
	
	public List<Cuenta> findAll() {

		return this.repository.findAll();

	}

	public List<Cuenta> findAllByBancoId(int idBanco){
	
		return this.repository.findAllByBancoId(idBanco);
	}
		
	public List<Cuenta> findAllByCliente(String dni){
		
		return this.repository.findAllByCliente(dni);
		
	}

}
