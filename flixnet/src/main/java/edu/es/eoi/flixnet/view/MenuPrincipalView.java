package edu.es.eoi.flixnet.view;

import java.util.Scanner;

public class MenuPrincipalView {
	
	@SuppressWarnings("resource")
	public static void printMenu() {
		
		System.out.println("Bienvenido a flixnet");
		System.out.println("Elija una opcion:");
		System.out.println("1-Buscar peliculas");
		System.out.println("2-Salir");	
	
		Scanner scan= new Scanner(System.in);		
		int opcion = scan.nextInt();
		
		switch (opcion) {
		case 1:	
			PeliculasBusquedaView.printMenu();
			break;

		default:
			LoginView.printLogin(); ///NOOOOOOOOOOO cortar dedos!
			break;
		}
	}

}
