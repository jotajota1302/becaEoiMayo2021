package edu.es.eoi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.dtos.BancoDto;
import edu.es.eoi.entities.Banco;
import edu.es.eoi.repositories.BancoRepository;

@Service
public class BancoService {

	@Autowired
	BancoRepository repository;

	@Autowired
	ModelMapper mapper;

	public BancoDto saveBanco(BancoDto banco) {

		this.repository.save(mapper.map(banco, Banco.class));

		return banco;

	}

	public BancoDto updateBanco(BancoDto banco) {

		this.repository.save(mapper.map(banco, Banco.class));

		return banco;

	}

	public void removeBanco(int id) {
		
		this.repository.deleteById(id);
	}

	public BancoDto findBanco(int id) {

		return mapper.map(this.repository.findById(id).get(), BancoDto.class);

	}

	public List<BancoDto> findAll() {

		return this.repository.findAll()
				              .stream()
				              .map(b -> mapper.map(b, BancoDto.class))
				              .collect(Collectors.toList());
	}

}
