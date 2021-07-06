package edu.es.eoi;

import edu.es.eoi.flixnet.entities.Pelicula;
import edu.es.eoi.flixnet.repository.PeliculaRepositoryJPAImpl;

public class PeliculasService {	
	
	PeliculaRepositoryJPAImpl repo= new PeliculaRepositoryJPAImpl();
	
	public Pelicula findPeliculaById(int id) {
		
		return repo.find(id);
		
	}

}
