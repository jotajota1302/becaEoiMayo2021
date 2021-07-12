package edu.es.eoi;

import org.springframework.stereotype.Repository;

@Repository
public class HelloWorldRepositoryImpl implements HelloWorldRepository {

	@Override
	public String saluda() {
		
		return "Hello world";

	}

}
