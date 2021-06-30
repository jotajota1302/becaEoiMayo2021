package edu.es.eoi.flixnet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.es.eoi.flixnet.entities.Usuario;
import edu.es.eoi.flixnet.repository.UsuarioRepository;
import edu.es.eoi.flixnet.repository.UsuarioRepositoryJDBCImpl;

public class UsuarioRepositoryJDBCImplTest {

	@Test
	public void test() {

		UsuarioRepository repository= new UsuarioRepositoryJDBCImpl();
		
		try {
			
			assertEquals(true,repository.comprueba(Usuario.builder().usuario("pepe").password("123456").build()));
			assertEquals(false,repository.comprueba(Usuario.builder().usuario("pepe").password("123125").build()));			
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}

}
