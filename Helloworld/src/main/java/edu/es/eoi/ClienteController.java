package edu.es.eoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@Autowired
	HelloWorldService service;
	
	@RequestMapping(value ="/clientes",method = RequestMethod.GET)
	public String findClientes() {
		
		//return todos los clientes
		
		return null;
		
	}
	
	@RequestMapping(value = "/clientes/{id}",method = RequestMethod.GET)
	public ResponseEntity<String> findCliente(@PathVariable String id) {		
		
		//tengo el id y recupero 1 cliente
		
		return null;	
		
	}
	
	@RequestMapping(value = "/clientes",method = RequestMethod.POST)
	public ResponseEntity<String> createCliente(@RequestBody String nombre,@RequestBody String dni) {		
		
		//tengo el nombre y dni
		
		return null;	
		
	}
	

	
}
