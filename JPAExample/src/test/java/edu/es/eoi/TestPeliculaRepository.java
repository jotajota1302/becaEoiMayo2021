package edu.es.eoi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.es.eoi.entities.Pelicula;
import com.es.eoi.repositories.PeliculaRepositoryJPAImpl;

public class TestPeliculaRepository {

	PeliculaRepositoryJPAImpl repository= new PeliculaRepositoryJPAImpl();
	
	@Test
	public void testSavePelicula() {		
		
		Pelicula p=Pelicula.builder().nombre("TEST").build();
		
		assertNotNull(repository.savePelicula(p).getId());
		
	}

	@Test
	public void testUpdatePelicula() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemovePelicula() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindPelicula() {
		fail("Not yet implemented");
	}

}
