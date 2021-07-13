package edu.es.eoi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.entities.Cliente;
import edu.es.eoi.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService service;

	@GetMapping("/clientes/{dni}")
	public ResponseEntity<Cliente> findCliente(@PathVariable String dni) {

		return new ResponseEntity<Cliente>(service.findCliente(dni), HttpStatus.OK);

	}

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> findAllClientes() {

		return new ResponseEntity<List<Cliente>>(service.findAll(), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/clientes")
	public ResponseEntity<?> createCliente(@RequestParam String dni, @RequestParam String nombre,
			@RequestParam String direccion) {

		if(null==dni||dni.isEmpty()) {			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);		
		}
		
		if (service.findCliente(dni) == null) {

			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			
		} else {
			
			service.saveCliente(new Cliente(dni, nombre, direccion));

			return new ResponseEntity<String>(HttpStatus.CREATED);
		}

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes/{dni}")
	public ResponseEntity<?> updateCliente(@PathVariable String dni, @RequestParam String nombre,@RequestParam String direccion) {

		if(null==dni||dni.isEmpty()) {			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);		
		}
		
		if (service.findCliente(dni) == null) {

			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			
		} else {
			
			service.updateCliente(new Cliente(dni, nombre, direccion));

			return new ResponseEntity<String>(HttpStatus.CREATED);
		}

	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{dni}")
	public ResponseEntity<?> createCliente(@PathVariable String dni){

		if(null==dni||dni.isEmpty()) {			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);		
		}		
			service.removeCliente(new Cliente(dni,"",""));

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	

	}
	
	

}
