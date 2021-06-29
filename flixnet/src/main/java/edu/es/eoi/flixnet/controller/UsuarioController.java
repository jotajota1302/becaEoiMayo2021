package edu.es.eoi.flixnet.controller;

import org.apache.log4j.Logger;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.GeneroEnum;
import edu.es.eoi.flixnet.entities.Usuario;
import edu.es.eoi.flixnet.service.PeliculaService;
import edu.es.eoi.flixnet.service.UsuarioService;
import edu.es.eoi.flixnet.view.MenuPrincipalView;

public class UsuarioController {

	private static Logger logger= Logger.getLogger(UsuarioController.class);
	
	private UsuarioService usuarioService = new UsuarioService();
	
	private PeliculaService peliculaService = new PeliculaService();

	public void login(String nombre, String password) {
		
		logger.info("Entro en el metodo login");

		Usuario user = Usuario.builder().usuario(nombre).password(password).build();

		logger.debug("Compruebo el usuario:" + nombre);

		boolean existe = false;
			
		existe = usuarioService.comprueba(user);		

		logger.debug("El usuario existe: " + existe);	
	

		if (existe) {
			
			logger.info("Salgo del metodo login");
			
			MenuPrincipalView.printMenu();
		}	
		
		logger.info("Salgo del metodo login");

	}

	public void buscarPelicula(String nombre, Actor actor, GeneroEnum genero) {

		logger.info("Entro en el metodo buscar pelicula");

		
		if (nombre != null) {
			
			logger.debug("Entro en el metodo buscar por nombre: " + nombre);
			
			peliculaService.buscarPorNombre(nombre);
			
		}
		if (actor != null) {
			
			logger.debug("Entro en el metodo buscar por actor: " + actor.getNombre());
			
			peliculaService.buscarPorActor(actor);
			
		}

	}

	public void reproducir() {
		// TODO implement

	}

}
