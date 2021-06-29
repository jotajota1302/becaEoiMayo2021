package edu.es.eoi.flixnet.service;

import java.util.List;

import org.apache.log4j.Logger;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.entities.Pelicula;
import edu.es.eoi.flixnet.repository.PeliculaRepository;
import edu.es.eoi.flixnet.repository.PeliculaRepositoryJDBCImpl;

public class PeliculaService {

	private static Logger logger= Logger.getLogger(PeliculaService.class);		
	
//	private PeliculaRepository repository = new PeliculaRepositoryMemoryImpl();
	
	private PeliculaRepository repository = new PeliculaRepositoryJDBCImpl();

	public List<Pelicula> buscarPorActor(Actor actor) {

		logger.info("entro al metodo buscar por actor");
				
		return this.repository.buscarPorActor(actor);
	}

	public List<Pelicula> buscarPorGenero(GeneroEnum genero) throws Exception {
	
		logger.info("entro al metodo buscar por genero");
		
		return this.repository.buscarPorGenero(genero);
	}

	public List<Pelicula> buscarPorNombre(String nombre) {
		
		logger.info("entro al metodo buscar por nombre");
	
		return this.repository.buscarPorNombre(nombre);
	}

	public void reproducir(Pelicula pelicula) {
		// TODO
	}
}
