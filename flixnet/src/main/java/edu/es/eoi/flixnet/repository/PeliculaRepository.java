package edu.es.eoi.flixnet.repository;

import java.util.List;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.entities.Pelicula;

public interface PeliculaRepository {

	List<Pelicula> buscarPorActor(Actor actor);

	List<Pelicula> buscarPorGenero(GeneroEnum genero);

	List<Pelicula> buscarPorNombre(String nombre);

}