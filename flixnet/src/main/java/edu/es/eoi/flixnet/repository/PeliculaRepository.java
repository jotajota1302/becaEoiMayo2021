package edu.es.eoi.flixnet.repository;

import java.util.List;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.entities.Pelicula;

public class PeliculaRepository {
	
	public List<Pelicula> buscarPorActor(Actor actor) {
		//TODO
		System.out.println("busco por actor " + this.getClass().getSimpleName());
		return null;
	}

	public List<Pelicula> buscarPorGenero(GeneroEnum genero) {
		//TODO		
		if(genero.equals(GeneroEnum.ACCION)) {
			System.out.println("cuidado con las peliculas pegi+18");
		}
		
		System.out.println("busco por genero " + this.getClass().getSimpleName());
		return null;
	}

	public List<Pelicula> buscarPorNombre(String nombre) {
		//TODO
		System.out.println("busco por nombre " + this.getClass().getSimpleName());
		return null;
	}

}
