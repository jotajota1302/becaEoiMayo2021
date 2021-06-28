package edu.es.eoi;

import java.util.ArrayList;
import java.util.List;

import edu.es.eoi.flixnet.entities.Usuario;
import edu.es.eoi.flixnet.view.LoginView;

public class MainApp {
	
	public static List<Usuario> usuarios= new ArrayList<Usuario>();

	public static void main(String[] args) {
	
		initData();
		
		LoginView.printLogin();		
		
		main(args);
		
	}

	private static void initData() {

		Usuario usuario1= new Usuario("Pepe","123456");	
		Usuario usuario2= new Usuario("Maria","111111");		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		
		
	}

}
