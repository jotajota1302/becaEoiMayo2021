package edu.es.eoi.flixnet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.repository.PeliculaRepository;
import edu.es.eoi.flixnet.repository.PeliculaRepositoryJDBCImpl;

class PeliculaRepositoryJDBCImplTest {

	@Test
	void testBuscarPorGenero() {
		
		PeliculaRepository repository= new PeliculaRepositoryJDBCImpl();
		
		try {
		
		assertNotNull(repository.buscarPorGenero(GeneroEnum.ACCION).size());	
		
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
	}

}
