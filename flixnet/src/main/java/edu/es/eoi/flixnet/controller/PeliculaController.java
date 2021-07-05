package edu.es.eoi.flixnet.controller;

import java.util.List;

import org.apache.log4j.Logger;

import edu.es.eoi.flixnet.entities.Pelicula;
import edu.es.eoi.flixnet.service.PeliculaService;
import edu.es.eoi.flixnet.view.PeliculasBusquedaView;

public class PeliculaController {
	
	private static Logger logger=Logger.getLogger(PeliculaController.class);
	
	PeliculaService service= new PeliculaService();
	
	public static void buscarPeliculasMenu(){
		
		logger.info("navego al menu de busqueda de peliculas");
		
		PeliculasBusquedaView.printMenu();				
	}	
	
	public List<Pelicula> buscarPeliculaPorGenero(String genero){
		
		logger.info("entro al metodo buscar peliculas por genero");
		
		try {			
			return service.buscarPorGenero(genero);
		
		} catch (Exception e) {
			logger.debug(e.getStackTrace());
			System.out.println("Ha ocurrido un error");
		}
		
		return null;
		
	}
	
	public void mostrarResultadosBusqueda(List<Pelicula> peliculas) {
		
		logger.info("entro al metodo mostrar resultados busqueda");
		
		PeliculasBusquedaView.printResultadoBusqueda(peliculas);
		
	}

	public static void generarExcel() {
	
		PeliculaService service= new PeliculaService();
				
		try {
			service.generateExcelPeliculas(service.buscarPorGenero("Accion"));
		
		} catch (Exception e) {
			
			logger.debug(e.getStackTrace());
		}
		
	}

}
