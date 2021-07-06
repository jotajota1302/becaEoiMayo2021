package edu.es.eoi.flixnet;


import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.es.eoi.flixnet.repository.PeliculaRepositoryJPAImpl;


public class PeliculaRepositoryTest {

	@Before
	public void beforeTests() {
		
		//se ejecuta antes de los test
	}
	
	@After
	public void afterTests() {
		
		//se ejecuta despues de los test
		
	}
	
	
	@Test
	public void testBuscar() {
		
		PeliculaRepositoryJPAImpl repository= new PeliculaRepositoryJPAImpl();
		
		try {
		
		assertNotNull(repository.find(1));	
				
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
	}

}
