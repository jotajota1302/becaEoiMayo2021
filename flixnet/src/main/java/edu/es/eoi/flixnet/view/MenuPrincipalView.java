package edu.es.eoi.flixnet.view;

import java.util.Scanner;

import edu.es.eoi.flixnet.controller.UsuarioController;

public class MenuPrincipalView {
	
	@SuppressWarnings("resource")
	public static void printMenu() {
		
		System.out.println("Bienvenido a flixnet");
		System.out.println("Elija una opcion:");
		System.out.println("1-Buscar peliculas");
		System.out.println("2-Generar Excel peliculas");	
		System.out.println("3-Salir");	
	
		Scanner scan= new Scanner(System.in);		
		int opcion = scan.nextInt();
		
		switch (opcion) {
		case 1:	
//			PeliculaController.buscarPeliculasMenu();;
			break;
		case 2:	
//			PeliculaController.generarExcel();
			break;
		default:
			UsuarioController.logOut();
			break;
		}
	}

}
