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

		Usuario user = new Usuario();
		user.setNombre(nombre);
		user.setPassword(password);
			
		logger.debug("Compruebo el usuario:" + nombre);

		boolean existe = false;

		try {
			existe = usuarioService.comprueba(user);
			
			logger.debug("El usuario existe: " + existe);

			if (existe) {

				logger.info("Salgo del metodo login");
				MenuPrincipalView.printMenu();
			}
			
		} catch (Exception e) {
			logger.debug("Ha ocurrido un error");
			MenuPrincipalView.printMenu();
		}

		logger.info("Salgo del metodo login");

	}

	public static void logOut() {

		LoginView.printLogin();

	}


}
