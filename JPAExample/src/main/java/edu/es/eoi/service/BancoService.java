package edu.es.eoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.entities.Banco;
import edu.es.eoi.repositories.BancoRepository;

@Service
public class BancoService {
	
	@Autowired
	BancoRepository repository;
	
	public Banco saveBanco(Banco banco) {
		
	 return	this.repository.saveBanco(banco);
		
	}
	
	public Banco updateBanco(Banco banco) {
		
		return this.repository.updateBanco(banco);
		
	}

	public void removeBanco(Banco banco) {
		
		this.repository.removeBanco(banco);
	}

	public Banco findBanco(int id) {
		
		return this.repository.findBanco(id);
		
	}

	public List<Banco> findAll(){
		
		return this.repository.findAll();
		
	}

}
