package edu.es.eoi.flixnet.repository;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.Pelicula;

public class PeliculaRepositoryJPAImpl extends AbstractCRUDRepository<Pelicula, Integer> implements PeliculaRepository {
	
	public PeliculaRepositoryJPAImpl() {		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PeliculasPersistenceUnit");
		super.em = factory.createEntityManager();
		super.setType(Pelicula.class);
	}
	
	@Override
	public List<Pelicula> buscarPorActor(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> buscarPorGenero(String genero) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
