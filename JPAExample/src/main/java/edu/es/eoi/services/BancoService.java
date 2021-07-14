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

		this.repository.saveBanco(mapper.map(banco, Banco.class));

		return banco;

	}

	public BancoDto updateBanco(BancoDto banco) {

		this.repository.updateBanco(mapper.map(banco, Banco.class));

		return banco;

	}

	public void removeBanco(BancoDto banco, int id) {

		Banco b=mapper.map(banco, Banco.class);
		b.setId(id);
		
		this.repository.removeBanco(b);
	}

	public BancoDto findBanco(int id) {

		return mapper.map(this.repository.findBanco(id), BancoDto.class);

	}

	public List<BancoDto> findAll() {

		return this.repository.findAll()
				              .stream()
				              .map(b -> mapper.map(b, BancoDto.class))
				              .collect(Collectors.toList());
	}

}
