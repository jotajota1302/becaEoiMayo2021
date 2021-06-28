package edu.es.eoi.flixnet.repository;

import edu.es.eoi.MainApp;
import edu.es.eoi.flixnet.entities.Usuario;

public class UsuarioRepositoryMemoryImpl implements UsuarioRepository {

	@Override
	public boolean comprueba(Usuario usuario) {
		
		return MainApp.usuarios.contains(usuario);
		
	}

	@Override
	public void alta(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

}
