package edu.es.eoi.flixnet;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.service.PeliculaService;

public class PeliculasServiceTest {

	PeliculaService service= new PeliculaService();
	
	@Test
	public void testBuscarPorGenero() {

		try {
			
			assertNotNull(service.buscarPorGenero(GeneroEnum.ACCION));
			
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
	}

}
