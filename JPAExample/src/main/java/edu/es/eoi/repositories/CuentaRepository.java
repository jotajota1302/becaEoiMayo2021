package edu.es.eoi.repositories;

import java.util.List;

import edu.es.eoi.entities.Cuenta;

public interface CuentaRepository {

	Cuenta saveCuenta(Cuenta cuenta);

	Cuenta updateCuenta(Cuenta cuenta);

	void removeCuenta(Cuenta cuenta);

	Cuenta findCuenta(int id);

	List<Cuenta> findAllByBancoId(int idBanco);

	List<Cuenta> findAllByCliente(String dni);

	List<Cuenta> findAll();

}