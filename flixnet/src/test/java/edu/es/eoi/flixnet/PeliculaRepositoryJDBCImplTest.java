package edu.es.eoi.flixnet;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.repository.PeliculaRepository;
import edu.es.eoi.flixnet.repository.PeliculaRepositoryJDBCImpl;


public class PeliculaRepositoryJDBCImplTest {

	@Test
	public void testBuscarPorGenero() {
		
		PeliculaRepository repository= new PeliculaRepositoryJDBCImpl();
		
		try {
		
		assertNotNull(repository.buscarPorGenero(GeneroEnum.ACCION).size());	
		assertEquals(0,repository.buscarPorGenero(GeneroEnum.FANTASIA).size());
		
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
	}

}
