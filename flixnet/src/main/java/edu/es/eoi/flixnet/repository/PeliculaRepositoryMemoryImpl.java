package edu.es.eoi.flixnet.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.Pelicula;

public class PeliculaRepositoryMemoryImpl implements PeliculaRepository {

	private static Logger logger= Logger.getLogger(PeliculaRepositoryMemoryImpl.class);
	
	private List<Pelicula> peliculas = new ArrayList<Pelicula>();

	public PeliculaRepositoryMemoryImpl() {

		peliculas.add(new Pelicula(0, "Jungla de Cristal 1", null, "Accion"));
		peliculas.add(new Pelicula(1, "Jungla de Cristal 2", null, "Accion"));
		peliculas.add(new Pelicula(2, "Jungla de Cristal 3", null, "Accion"));
		peliculas.add(new Pelicula(3, "Ace Ventura", null, "Comedia"));
		peliculas.add(new Pelicula(4, "El diario de Noa", null, "Amor"));	

	}

	@Override
	public List<Pelicula> buscarPorActor(Actor actor) {
		
		logger.info("entro en el metodo de buscar por actor");
		// TODO		
		logger.debug("busco por actor " + actor.getNombre());	
		
		return null;
	}

	@Override
	public List<Pelicula> buscarPorGenero(String genero) {

		logger.info("entro en el metodo de buscar por genero");
	
		logger.debug("busco por genero " + genero);			
			
		return this.peliculas.stream().filter(p -> p.getGenero().equals(genero)).collect(Collectors.toList());

	}

	@Override
	public List<Pelicula> buscarPorNombre(String nombre) {
		
		logger.info("entro en el metodo de buscar por nombre");
		
		logger.debug("busco por genero " + nombre);			
		
		return this.peliculas.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());
	}
}


