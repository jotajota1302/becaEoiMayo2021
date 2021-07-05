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
			
			
			
			assertEquals(true,repository.comprueba(new Usuario("Pepe","123456",false,null,null)));
			assertEquals(false,repository.comprueba(new Usuario("Pep","123456",false,null,null)));			
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}

}
