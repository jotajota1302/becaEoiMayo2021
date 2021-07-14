package edu.es.eoi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.dtos.CuentaDto;
import edu.es.eoi.services.CuentaService;

@RestController
public class CuentasController {

	@Autowired
	CuentaService service;

	@GetMapping("/cuentas/{id}")
	public ResponseEntity<CuentaDto> findCuenta(@PathVariable Integer id) {

		return new ResponseEntity<CuentaDto>(service.findCuenta(id), HttpStatus.OK);

	}

	@GetMapping("/cuentas")
	public ResponseEntity<List<CuentaDto>> findAllCuentas() {

		return new ResponseEntity<List<CuentaDto>>(service.findAll(), HttpStatus.OK);

	}

	@GetMapping("/cuentas/{dni}/cliente")
	public ResponseEntity<List<CuentaDto>> findAllCuentasByCliente(@PathVariable String dni) {

		return new ResponseEntity<List<CuentaDto>>(service.findAllByCliente(dni), HttpStatus.OK);

	}

	@GetMapping("/cuentas/{id}/banco")
	public ResponseEntity<List<CuentaDto>> findAllCuentasByBanco(@PathVariable Integer id) {

		return new ResponseEntity<List<CuentaDto>>(service.findAllByBancoId(id), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/cuentas")
	public ResponseEntity<?> createCuenta(@RequestBody CuentaDto cuenta) {

		service.saveCuenta(cuenta);

		return new ResponseEntity<String>(HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/cuentas/{id}")
	public ResponseEntity<?> updateCuenta(@PathVariable Integer id, @RequestBody CuentaDto cuenta) {

		if (null == id) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		service.updateCuenta(cuenta);

		return new ResponseEntity<String>(HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/cuentas/{id}")
	public ResponseEntity<?> deleteCuenta(@PathVariable Integer id) {

		if (null == id) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		service.removeCuenta(id);

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);

	}

}
