package edu.es.eoi.flixnet.repository;

import edu.es.eoi.flixnet.entities.Usuario;

public class UsuarioRepositoryFileTextImpl implements UsuarioRepository {

	@Override
	public boolean comprueba(Usuario usuario){

		//leer fichero y comprobar que el usuario con el nombre tiene el password
					
		return true;
		
	}

	@Override
	public void alta(Usuario usuario) {
		// TODO Auto-generated method stub

	}

}
