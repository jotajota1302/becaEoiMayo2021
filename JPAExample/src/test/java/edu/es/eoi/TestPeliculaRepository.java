package edu.es.eoi;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.es.eoi.entities.Pelicula;
import com.es.eoi.repositories.PeliculaRepositoryJPAImpl;

public class TestPeliculaRepository {

	PeliculaRepositoryJPAImpl repository= new PeliculaRepositoryJPAImpl();
	List<Integer> ids=new ArrayList<Integer>();	 
	
	@Test
	public void testSavePelicula() {		
		
		Pelicula p=Pelicula.builder().nombre("TEST").build();		
		p=repository.savePelicula(p);		
		ids.add(p.getId());		
		
		assertNotNull(repository.findPelicula(p.getId()));
		
	}

	@Test
	public void testUpdatePelicula() {

		Pelicula p=Pelicula.builder().nombre("TEST").build();
		repository.savePelicula(p);
		
		ids.add(p.getId());		
		
		p.setNombre("MODIFIED");
		p=repository.updatePelicula(p);
		
		assertNotNull("MODIFIED",p.getNombre());
	}

	@Test
	public void testRemovePelicula() {
		
		Pelicula p=Pelicula.builder().nombre("TEST").build();
		p=repository.savePelicula(p);
		
		repository.removePelicula(p);
		
		assertNull(repository.findPelicula(p.getId()));
		
	}

	@Test
	public void testFindPelicula() {
		
		Pelicula p=Pelicula.builder().nombre("TEST").build();
		p=repository.savePelicula(p);
		
		ids.add(p.getId());		
		
		assertNotNull(repository.findPelicula(p.getId()));
	}
	
	@After
	public void clear() {
		
		for (Integer id : ids) {
			repository.removePelicula(repository.findPelicula(id));
		}
		
	}

}
