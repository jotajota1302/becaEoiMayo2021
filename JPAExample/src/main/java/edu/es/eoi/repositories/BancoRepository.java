package edu.es.eoi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.es.eoi.entities.Banco;

public interface BancoRepository extends JpaRepository<Banco, Integer> {


}