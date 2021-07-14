package edu.es.eoi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.dtos.ClienteDto;
import edu.es.eoi.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService service;

	@GetMapping("/clientes/{dni}")
	public ResponseEntity<ClienteDto> findCliente(@PathVariable String dni) {

		return new ResponseEntity<ClienteDto>(service.findCliente(dni), HttpStatus.OK);

	}

	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDto>> findAllClientes() {

		return new ResponseEntity<List<ClienteDto>>(service.findAll(), HttpStatus.OK);

	}
	
	@GetMapping("/clientes/nombre/{nombre}")
	public ResponseEntity<List<ClienteDto>> findAllClientesByNombre(@PathVariable String nombre) {

		return new ResponseEntity<List<ClienteDto>>(service.findAllByNombre(nombre), HttpStatus.OK);

	}

	@PostMapping("/clientes")
	public ResponseEntity<ClienteDto> createCliente(@RequestBody ClienteDto cliente) {

			service.saveCliente(cliente);

			return new ResponseEntity<ClienteDto>(HttpStatus.CREATED);		

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes/{dni}")
	public ResponseEntity<?> updateCliente(@PathVariable String dni, @RequestBody ClienteDto cliente) {
					
			service.updateCliente(cliente);

			return new ResponseEntity<String>(HttpStatus.CREATED);		

	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{dni}")
	public ResponseEntity<?> deleteCliente(@PathVariable String dni){

		if(null==dni||dni.isEmpty()) {			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);		
		}		
			service.removeCliente(dni);

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	

	}
	
	

}
