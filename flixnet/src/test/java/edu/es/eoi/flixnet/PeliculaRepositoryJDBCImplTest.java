package edu.es.eoi.flixnet;


import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.repository.PeliculaRepository;
import edu.es.eoi.flixnet.repository.PeliculaRepositoryJDBCImpl;


public class PeliculaRepositoryJDBCImplTest {

	@Before
	public void beforeTests() {
		
		//se ejecuta antes de los test
	}
	
	@After
	public void afterTests() {
		
		//se ejecuta despues de los test
		
	}
	
	
	@Test
	public void testBuscarPorGenero() {
		
		PeliculaRepository repository= new PeliculaRepositoryJDBCImpl();
		
		try {
		
		assertNotNull(repository.buscarPorGenero(GeneroEnum.ACCION).size());	
				
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
	}

}
