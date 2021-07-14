package edu.es.eoi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.es.eoi.entities.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

	public List<Cuenta> findAllByClienteDni(String dni);
	
	public List<Cuenta> findAllByBancoId(Integer id);

}