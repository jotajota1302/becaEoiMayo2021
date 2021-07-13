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

import edu.es.eoi.entities.Cuenta;
import edu.es.eoi.services.CuentaService;

@RestController
public class CuentasController {

	@Autowired
	CuentaService service;

	@GetMapping("/cuentas/{id}")
	public ResponseEntity<Cuenta> findCuenta(@PathVariable Integer id) {

		return new ResponseEntity<Cuenta>(service.findCuenta(id), HttpStatus.OK);

	}

	@GetMapping("/cuentas")
	public ResponseEntity<List<Cuenta>> findAllCuentas() {

		return new ResponseEntity<List<Cuenta>>(service.findAll(), HttpStatus.OK);

	}
	
	@GetMapping("/cuentas/{dni}/cliente")
	public ResponseEntity<List<Cuenta>> findAllCuentasByCliente(@PathVariable String dni) {

		return new ResponseEntity<List<Cuenta>>(service.findAllByCliente(dni), HttpStatus.OK);

	}
	
	@GetMapping("/cuentas/{id}/banco")
	public ResponseEntity<List<Cuenta>> findAllCuentasByBanco(@PathVariable Integer id) {

		return new ResponseEntity<List<Cuenta>>(service.findAllByBancoId(id), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/cuentas")
	public ResponseEntity<?> createCuenta(@RequestParam Integer id, @RequestParam Double saldo) {

		if(null==id) {			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);		
		}
		
		if (service.findCuenta(id) == null) {

			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			
		} else {
			
			service.saveCuenta(new Cuenta(id,saldo));

			return new ResponseEntity<String>(HttpStatus.CREATED);
		}

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/cuentas/{id}")
	public ResponseEntity<?> updateCuenta(@PathVariable Integer id,@RequestParam Double saldo) {

		if(null==id) {			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);		
		}
		
		if (service.findCuenta(id) == null) {

			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			
		} else {
			
			service.updateCuenta(new Cuenta(id,saldo));

			return new ResponseEntity<String>(HttpStatus.CREATED);
		}

	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/cuentas/{id}")
	public ResponseEntity<?> createCuenta(@PathVariable Integer id){

		if(null==id) {			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);		
		}		
			service.removeCuenta(new Cuenta(id,0.0));

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	

	}
	
	

}
