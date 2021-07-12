package edu.es.eoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@Autowired
	HelloWorldService service;
	
	@RequestMapping(value ="/cliente",method = RequestMethod.GET)
	public String saluda(String parametro) {
		
		//return todos los clientes
		
		return null;
		
	}
	
	@RequestMapping(value = "/saluda2",method = RequestMethod.GET)
	public ResponseEntity<String> saluda2() {
		
		return new ResponseEntity<String>(service.saluda(),HttpStatus.OK);
		
	}
	

	
}
