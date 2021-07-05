package edu.es.eoi.flixnet.view;import java.util.List;
import java.util.Scanner;

import edu.es.eoi.flixnet.controller.PeliculaController;
import edu.es.eoi.flixnet.entities.Pelicula;

public class PeliculasBusquedaView {
	
	public static PeliculaController controller= new PeliculaController();
	
	@SuppressWarnings("resource")
	public static void printMenu() {
		
		System.out.println("Elige un genero:");		
		
		Scanner scan=new Scanner(System.in);
		String opcion= scan.next();				
		
		List<Pelicula> peliculas = controller.buscarPeliculaPorGenero(opcion);		
		
		controller.mostrarResultadosBusqueda(peliculas);
		
	}
	
	
	public static void printResultadoBusqueda(List<Pelicula> peliculas) {
		
		for (Pelicula pelicula : peliculas) {
			System.out.println("Nombre: " + pelicula.getNombre() );
		}
		
	}

}
