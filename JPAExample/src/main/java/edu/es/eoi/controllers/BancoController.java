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

import edu.es.eoi.dtos.BancoDto;
import edu.es.eoi.services.BancoService;

@RestController
public class BancoController {

	@Autowired
	BancoService service;

	@GetMapping("/bancos/{id}")
	public ResponseEntity<BancoDto> findBanco(@PathVariable Integer id) {

		return new ResponseEntity<BancoDto>(service.findBanco(id), HttpStatus.OK);

	}

	@GetMapping("/bancos")
	public ResponseEntity<List<BancoDto>> findAllBanco() {

		return new ResponseEntity<List<BancoDto>>(service.findAll(), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/bancos")
	public ResponseEntity<BancoDto> createBanco(@RequestBody BancoDto banco) {

		return new ResponseEntity<BancoDto>(service.saveBanco(banco), HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/bancos/{id}")
	public ResponseEntity<?> updateBanco(@PathVariable Integer id, @RequestBody BancoDto banco) {

		if (null == id) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
			service.updateBanco(banco);

		return new ResponseEntity<String>(HttpStatus.CREATED);
	
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/bancos/{id}")
	public ResponseEntity<?> deleteBanco(@PathVariable Integer id) {

		if (null == id) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		service.removeBanco(BancoDto.builder().build(),id);

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);

	}

}
