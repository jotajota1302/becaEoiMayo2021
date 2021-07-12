package edu.es.eoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AlumnoController {
	
	@Autowired	
	public AlumnoService service;

}
