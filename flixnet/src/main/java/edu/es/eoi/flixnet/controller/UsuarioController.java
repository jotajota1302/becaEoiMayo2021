package edu.es.eoi.flixnet.controller;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.entities.Usuario;
import edu.es.eoi.flixnet.service.PeliculaService;
import edu.es.eoi.flixnet.service.UsuarioService;
import edu.es.eoi.flixnet.view.MenuPrincipalView;

public class UsuarioController {

	private UsuarioService usuarioService = new UsuarioService();
	private PeliculaService peliculaService = new PeliculaService();

	public void login(String nombre, String password) {

		Usuario user = Usuario.builder().usuario(nombre).password(password).build();

		System.out.println("compruebo user" + this.getClass().getSimpleName());

		boolean existe = false;
			
		existe = usuarioService.comprueba(user);		

		System.out.println("¿El usuario existe? :" + existe);

		if (existe) {
			MenuPrincipalView.printMenu();
		}

	}

	public void buscarPelicula(String nombre, Actor actor, GeneroEnum genero) {

		if (nombre != null) {
			peliculaService.buscarPorNombre(nombre);
			System.out.println("busco por nombre");
		}
		if (actor != null) {
			peliculaService.buscarPorActor(actor);
			System.out.println("busco por nombre");
		}

	}

	public void reproducir() {
		// TODO implement

	}

}
