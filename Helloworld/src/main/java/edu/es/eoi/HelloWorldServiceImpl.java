package edu.es.eoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	@Autowired
	HelloWorldRepository repository;
	
	@Override
	public String saluda() {
	
		return repository.saluda();

	}

}
