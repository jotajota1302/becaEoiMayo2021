package edu.es.eoi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import edu.es.eoi.entities.Pelicula;
import edu.es.eoi.repositories.PeliculaRepositoryJPAImpl;

public class TestPeliculaRepository {

	PeliculaRepositoryJPAImpl repository= new PeliculaRepositoryJPAImpl();
	List<Integer> ids=new ArrayList<Integer>();	 
	
	@Test
	public void testSavePelicula() {		
		
		Pelicula p=new Pelicula();
		p.setNombre("TEST");
		p=repository.savePelicula(p);		
		ids.add(p.getId());		
		
		assertNotNull(repository.findPelicula(p.getId()));
		
	}

	@Test
	public void testUpdatePelicula() {

		Pelicula p=new Pelicula();
		p.setNombre("TEST");
		p=repository.savePelicula(p);		
		ids.add(p.getId());		
		
		p.setNombre("MODIFIED");
		p=repository.updatePelicula(p);
		
		assertNotNull("MODIFIED",p.getNombre());
	}

	@Test
	public void testRemovePelicula() {
		
		Pelicula p=new Pelicula();
		p.setNombre("TEST");
		p=repository.savePelicula(p);
		
		repository.removePelicula(p);
		
		assertNull(repository.findPelicula(p.getId()));
		
	}

	@Test
	public void testFindPelicula() {
		
		Pelicula p=new Pelicula();
		p.setNombre("TEST");
		p=repository.savePelicula(p);		
		ids.add(p.getId());		
		
		assertNotNull(repository.findPelicula(p.getId()));
	}
	
	@Test
	public void testFindByGenero() {		
				
		List<Pelicula> lista=repository.findPeliculaByGenero("ACCION");
				
		assertEquals(3,lista.size());
	}
	
	@After
	public void clear() {
		
		for (Integer id : ids) {
			repository.removePelicula(repository.findPelicula(id));
		}
		
	}

}
