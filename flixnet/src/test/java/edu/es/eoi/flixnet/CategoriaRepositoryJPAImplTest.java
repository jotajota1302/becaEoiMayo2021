package edu.es.eoi.flixnet;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import edu.es.eoi.flixnet.entities.Categoria;
import edu.es.eoi.flixnet.repository.CategoriaRepositoryJPAImpl;


public class CategoriaRepositoryJPAImplTest {
	
	@Test
	public void testRepository() {
		
		CategoriaRepositoryJPAImpl repository= new CategoriaRepositoryJPAImpl();
		
		Categoria categoria= new Categoria();
		categoria.setNombre("TEST");
		
		categoria=repository.save(categoria);
		
		assertNotNull(repository.find(categoria.getId()));
		
		repository.remove(categoria);
		
		assertNull(repository.find(categoria.getId()));				
		
	}

}
