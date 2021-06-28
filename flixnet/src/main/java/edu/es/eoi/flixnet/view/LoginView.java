package edu.es.eoi.flixnet.view;

import java.util.Scanner;

import edu.es.eoi.flixnet.controller.UsuarioController;

public class LoginView {
	
	public static UsuarioController controller= new UsuarioController();
	
	public static void printLogin() {
		
		System.out.println("Introduce usuario: ");		
		@SuppressWarnings("resource")
		Scanner scan= new Scanner(System.in);
		
		String user=scan.nextLine();	
				
		System.out.println("Introduce contraseña:");
		scan= new Scanner(System.in);	
		
		String pw=scan.nextLine();		
		
		controller.login(user, pw);
		
	}

}
