package edu.es.eoi.flixnet.service;

import java.util.List;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.entities.Pelicula;
import edu.es.eoi.flixnet.repository.PeliculaRepository;

public class PeliculaService {

	private PeliculaRepository repository = new PeliculaRepository();

	public List<Pelicula> buscarPorActor(Actor actor) {

		System.out.println(this.getClass().getSimpleName());

		return this.repository.buscarPorActor(actor);
	}

	public List<Pelicula> buscarPorGenero(GeneroEnum genero) {

		System.out.println(this.getClass().getSimpleName());

		return this.repository.buscarPorGenero(genero);
	}

	public List<Pelicula> buscarPorNombre(String nombre) {
		
		System.out.println(this.getClass().getSimpleName());

		return this.repository.buscarPorNombre(nombre);
	}

	public void reproducir(Pelicula pelicula) {
		// TODO
	}
}
