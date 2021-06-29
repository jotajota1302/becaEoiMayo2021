package edu.es.eoi.flixnet.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.entities.Pelicula;

public class PeliculaRepositoryMemoryImpl implements PeliculaRepository {

	private List<Pelicula> peliculas = new ArrayList<Pelicula>();

	public PeliculaRepositoryMemoryImpl() {

		peliculas.add(Pelicula.builder().nombre("Jungla de Cristal 1").genero(GeneroEnum.ACCION).build());
		peliculas.add(Pelicula.builder().nombre("Jungla de Cristal 2").genero(GeneroEnum.ACCION).build());
		peliculas.add(Pelicula.builder().nombre("Jungla de Cristal 3").genero(GeneroEnum.ACCION).build());
		peliculas.add(Pelicula.builder().nombre("Ace Ventura").genero(GeneroEnum.COMEDIA).build());
		peliculas.add(Pelicula.builder().nombre("Mortadelo y Filemon").genero(GeneroEnum.COMEDIA).build());
		peliculas.add(Pelicula.builder().nombre("El diario de Noa").genero(GeneroEnum.AMOR).build());

	}

	@Override
	public List<Pelicula> buscarPorActor(Actor actor) {
		// TODO
		System.out.println("busco por actor " + this.getClass().getSimpleName());
		return null;
	}

	@Override
	public List<Pelicula> buscarPorGenero(GeneroEnum genero) {

		System.out.println("busco por genero " + this.getClass().getSimpleName());

		return this.peliculas.stream().filter(p -> p.getGenero().equals(genero)).collect(Collectors.toList());

	}

	@Override
	public List<Pelicula> buscarPorNombre(String nombre) {
		
		System.out.println("busco por nombre " + this.getClass().getSimpleName());
		
		return this.peliculas.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());
	}
}


