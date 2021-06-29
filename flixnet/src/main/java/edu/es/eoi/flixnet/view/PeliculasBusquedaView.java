package edu.es.eoi.flixnet.view;import java.util.List;
import java.util.Scanner;

import edu.es.eoi.flixnet.controller.PeliculaController;
import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.entities.Pelicula;

public class PeliculasBusquedaView {
	
	public static PeliculaController controller= new PeliculaController();
	
	@SuppressWarnings("resource")
	public static void printMenu() {
		
		System.out.println("Elige un genero:");
		for (GeneroEnum genero : GeneroEnum.values()) {
			System.out.println(genero.getCodigo()+"-"+genero.getDescripcion());			
		}
		
		Scanner scan=new Scanner(System.in);
		int opcion= scan.nextInt();
						
		GeneroEnum genero=GeneroEnum.getNombreBycodigo(opcion);
		
		List<Pelicula> peliculas = controller.buscarPeliculaPorGenero(genero);		
		
		controller.mostrarResultadosBusqueda(peliculas);
		
	}
	
	
	public static void printResultadoBusqueda(List<Pelicula> peliculas) {
		
		for (Pelicula pelicula : peliculas) {
			System.out.println("Nombre: " + pelicula.getNombre() );
		}
		
	}

}
