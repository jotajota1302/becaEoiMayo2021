package edu.es.eoi.flixnet.controller;

import java.util.List;

import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.entities.Pelicula;
import edu.es.eoi.flixnet.service.PeliculaService;
import edu.es.eoi.flixnet.view.PeliculasBusquedaView;

public class PeliculaController {
	
	PeliculaService service= new PeliculaService();
	
	public void buscarPeliculasMenu(){
		
		PeliculasBusquedaView.printMenu();
		
	}
	
	public List<Pelicula> buscarPeliculaPorGenero(GeneroEnum genero){
		
		return service.buscarPorGenero(genero);
		
	}
	
	public void mostrarResultadosBusqueda(List<Pelicula> peliculas) {
		
		PeliculasBusquedaView.printResultadoBusqueda(peliculas);
		
	}

}
