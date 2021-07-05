package edu.es.eoi.flixnet.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.es.eoi.flixnet.entities.Usuario;

public class UsuarioRepositoryMemoryImpl implements UsuarioRepository {

	private static Logger logger= Logger.getLogger(UsuarioRepositoryMemoryImpl.class);
	
	public static List<Usuario> usuarios = new ArrayList<Usuario>();

	public UsuarioRepositoryMemoryImpl() {

		logger.debug("cargo en memoria 2 usuarios");
		
		Usuario usuario1 =new Usuario("Pepe","123456",false,null,null);
		Usuario usuario2 =new Usuario("Maria","11111",false,null,null);
		usuarios.add(usuario1);
		usuarios.add(usuario2);

	}

	@Override
	public boolean comprueba(Usuario usuario) {

		logger.info("entro en el metodo de comprobar usuario");
		
		logger.debug("el metodo devuelve un :" + usuarios.contains(usuario));
		
		return usuarios.contains(usuario);

	}

	@Override
	public void alta(Usuario usuario) {

		logger.info("entro en el metodo de alta  usuario");		
		
		usuarios.add(usuario);
		
		logger.debug("usuario: "+ usuario +" añadido");

	}

}
