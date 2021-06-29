package edu.es.eoi.flixnet.service;

import java.util.List;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.entities.Pelicula;
import edu.es.eoi.flixnet.repository.PeliculaRepository;
import edu.es.eoi.flixnet.repository.PeliculaRepositoryMemoryImpl;

public class PeliculaService {

	private PeliculaRepository repository = new PeliculaRepositoryMemoryImpl();

	public List<Pelicula> buscarPorActor(Actor actor) {

			return this.repository.buscarPorActor(actor);
	}

	public List<Pelicula> buscarPorGenero(GeneroEnum genero) {
	
		return this.repository.buscarPorGenero(genero);
	}

	public List<Pelicula> buscarPorNombre(String nombre) {
		
	
		return this.repository.buscarPorNombre(nombre);
	}

	public void reproducir(Pelicula pelicula) {
		// TODO
	}
}
