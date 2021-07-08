package edu.es.eoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired	
	public AlumnoRepository repository;

	public void print() {
		this.repository.print();

	}

}
