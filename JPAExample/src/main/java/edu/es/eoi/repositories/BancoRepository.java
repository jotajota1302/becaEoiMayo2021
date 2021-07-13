package edu.es.eoi.repositories;

import java.util.List;

import edu.es.eoi.entities.Banco;

public interface BancoRepository {

	Banco saveBanco(Banco cliente);

	Banco updateBanco(Banco cliente);

	void removeBanco(Banco cliente);

	Banco findBanco(int id);

	List<Banco> findAll();

}