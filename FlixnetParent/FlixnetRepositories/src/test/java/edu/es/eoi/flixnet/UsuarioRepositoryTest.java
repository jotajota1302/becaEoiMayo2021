package edu.es.eoi.flixnet;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.es.eoi.flixnet.repository.UsuarioRepositoryJPAImpl;


public class UsuarioRepositoryTest {

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
		
		UsuarioRepositoryJPAImpl repository= new UsuarioRepositoryJPAImpl();
		
		try {
		
		assertEquals("pepe",repository.find("pepe").getUsuario());	
				
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
	}

}
