package edu.es.eoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	HelloWorldService service;
	
	@RequestMapping(value ="/saluda1",method = RequestMethod.GET)
	public String saluda(String parametro) {
		
		return service.saluda();
		
	}
	
	@RequestMapping(value = "/saluda2",method = RequestMethod.GET)
	public ResponseEntity<String> saluda2() {
		
		return new ResponseEntity<String>(service.saluda(),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/saluda3",method = RequestMethod.POST, params = "name")
	public ResponseEntity<String> saluda3(String name) {
		
		return new ResponseEntity<String>(service.saluda()+": "+name,HttpStatus.OK);
		
	}

	
}
