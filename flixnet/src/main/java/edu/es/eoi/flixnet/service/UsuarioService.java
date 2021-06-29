package edu.es.eoi.flixnet.service;

import org.apache.log4j.Logger;

import edu.es.eoi.flixnet.entities.Usuario;
import edu.es.eoi.flixnet.repository.UsuarioRepository;
import edu.es.eoi.flixnet.repository.UsuarioRepositoryFileTextImpl;

public class UsuarioService {

	private static Logger logger= Logger.getLogger(UsuarioService.class);
	
	private UsuarioRepository repository = new UsuarioRepositoryFileTextImpl();

	public boolean comprueba(Usuario usuario) {
		
		logger.info("entro en el metodo de comprueba usuario");
		
		logger.debug(usuario.getNombre());
		
		logger.info("salgo del metodo de comprueba usuario");
		
		return this.repository.comprueba(usuario);
	};

	public void alta(Usuario usuario) {
		
		System.out.println("alta usuario:" + this.getClass().getSimpleName());
		this.repository.alta(usuario);

	};

}
