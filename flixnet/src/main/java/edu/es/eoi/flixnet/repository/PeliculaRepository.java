package edu.es.eoi.flixnet.repository;

import java.util.List;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.Pelicula;

public interface PeliculaRepository {	

	List<Pelicula> buscarPorActor(Actor actor);

	List<Pelicula> buscarPorGenero(String genero) throws Exception;

	List<Pelicula> buscarPorNombre(String nombre);

}