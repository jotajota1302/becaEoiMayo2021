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

import edu.es.eoi.entities.Banco;
import edu.es.eoi.service.BancoService;

@RestController
public class BancoController {

	@Autowired
	BancoService service;

	@GetMapping("/bancos/{id}")
	public ResponseEntity<Banco> findBanco(@PathVariable Integer id) {

		return new ResponseEntity<Banco>(service.findBanco(id), HttpStatus.OK);

	}

	@GetMapping("/bancos")
	public ResponseEntity<List<Banco>> findAllBancos() {

		return new ResponseEntity<List<Banco>>(service.findAll(), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/bancos")
	public ResponseEntity<?> createBanco(@RequestParam Integer id, @RequestParam String nombre,
			@RequestParam String ciudad) {

		if (null == id) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		if (service.findBanco(id) != null) {

			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);

		} else {

			service.saveBanco(new Banco(id, nombre, ciudad));

			return new ResponseEntity<String>(HttpStatus.CREATED);
		}

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/bancos/{id}")
	public ResponseEntity<?> updateBanco(@PathVariable Integer id, @RequestParam String nombre,
			@RequestParam String ciudad) {

		if (null == id){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		if (service.findBanco(id) == null) {

			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);

		} else {

			service.updateBanco(new Banco(id, nombre, ciudad));

			return new ResponseEntity<String>(HttpStatus.CREATED);
		}

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/bancos/{id}")
	public ResponseEntity<?> createBanco(@PathVariable Integer id) {

		if (null == id) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		service.removeBanco(new Banco(id, "", ""));

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);

	}

}
