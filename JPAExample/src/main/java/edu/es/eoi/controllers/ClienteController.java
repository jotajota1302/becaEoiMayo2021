package edu.es.eoi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.entities.Cliente;
import edu.es.eoi.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	@GetMapping("/clientes/{dni}")
	public ResponseEntity<Cliente> findCliente(@PathVariable String dni){
		
		return new ResponseEntity<Cliente>(service.findCliente(dni), HttpStatus.OK);
		
	}
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> findAllClientes(){
		
		return new ResponseEntity<List<Cliente>>(service.findAll(), HttpStatus.OK);
		
	}
	
	
	

}
