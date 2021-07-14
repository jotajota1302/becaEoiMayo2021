package edu.es.eoi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.dtos.CuentaDto;
import edu.es.eoi.entities.Cuenta;
import edu.es.eoi.repositories.CuentaRepository;

@Service
public class CuentaService {
	
	@Autowired
	private CuentaRepository repository;
	
	@Autowired
	ModelMapper mapper;
		
	public CuentaDto saveCuenta(CuentaDto cuenta) {

			 this.repository.save(mapper.map(cuenta, Cuenta.class));
			 
	    return cuenta;
	}
	
	public CuentaDto updateCuenta(CuentaDto cuenta) {
		
		this.repository.save(mapper.map(cuenta, Cuenta.class));
	
		return cuenta;
	
	}
	

	public void removeCuenta(int id) {
		
		this.repository.deleteById(id);		
	}

	
	public CuentaDto findCuenta(int id) {

		return mapper.map(this.repository.findById(id), CuentaDto.class);

	}
	
	public List<CuentaDto> findAll() {

		return this.repository.findAll().stream().map(c-> mapper.map(c, CuentaDto.class)).collect(Collectors.toList());

	}

	public List<CuentaDto> findAllByBancoId(int idBanco){
	
		return null;
	}
		
	public List<CuentaDto> findAllByCliente(String dni){
		
		return null;
		
	}

}
