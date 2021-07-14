package edu.es.eoi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.es.eoi.entities.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {



}