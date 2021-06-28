package edu.es.eoi.flixnet.controller;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.entities.Usuario;
import edu.es.eoi.flixnet.service.PeliculaService;
import edu.es.eoi.flixnet.service.UsuarioService;
import edu.es.eoi.flixnet.view.MenuPrincipal;

public class UsuarioController {

	private UsuarioService usuarioService = new UsuarioService();
	private PeliculaService peliculaService = new PeliculaService();

	public void login(String nombre, String password) {

		Usuario user = new Usuario(nombre,password);		

		System.out.println("compruebo user" + this.getClass().getSimpleName());

		boolean existe = usuarioService.comprueba(user);

		System.out.println("¿El usuario existe? :" + existe);

		if (existe) {
			MenuPrincipal.printMenu();
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
