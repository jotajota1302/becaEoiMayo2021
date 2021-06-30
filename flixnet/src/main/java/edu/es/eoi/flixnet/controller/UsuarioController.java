package edu.es.eoi.flixnet.controller;

import org.apache.log4j.Logger;

import edu.es.eoi.flixnet.entities.Usuario;
import edu.es.eoi.flixnet.service.UsuarioService;
import edu.es.eoi.flixnet.view.LoginView;
import edu.es.eoi.flixnet.view.MenuPrincipalView;

public class UsuarioController {

	private static Logger logger = Logger.getLogger(UsuarioController.class);

	private UsuarioService usuarioService = new UsuarioService();	

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

	public static void logOut() {

		LoginView.printLogin();

	}


}
