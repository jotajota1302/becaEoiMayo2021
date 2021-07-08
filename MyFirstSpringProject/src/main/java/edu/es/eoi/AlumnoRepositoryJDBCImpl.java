package edu.es.eoi;

import org.springframework.stereotype.Repository;

@Repository
public class AlumnoRepositoryJDBCImpl implements AlumnoRepository {

	public void print() {
		
		System.out.println("imprimo desde el repositorio JDBC");
		
	}

}
