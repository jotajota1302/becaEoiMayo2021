package edu.es.eoi.flixnet.controller;

import java.util.List;

import org.apache.log4j.Logger;

import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.entities.Pelicula;
import edu.es.eoi.flixnet.service.PeliculaService;
import edu.es.eoi.flixnet.view.PeliculasBusquedaView;

public class PeliculaController {
	
	private static Logger logger=Logger.getLogger(PeliculaController.class);
	
	PeliculaService service= new PeliculaService();
	
	public void buscarPeliculasMenu(){
		
		logger.info("navego al menu de busqueda de peliculas");
		
		PeliculasBusquedaView.printMenu();		
		
	}
	
	public List<Pelicula> buscarPeliculaPorGenero(GeneroEnum genero){
		
		logger.info("entro al metodo buscar peliculas por genero");
		
		return service.buscarPorGenero(genero);
		
	}
	
	public void mostrarResultadosBusqueda(List<Pelicula> peliculas) {
		
		logger.info("entro al metodo mostrar resultados busqueda");
		
		PeliculasBusquedaView.printResultadoBusqueda(peliculas);
		
	}

}
