package edu.es.eoi.flixnet.repository;

import edu.es.eoi.flixnet.entities.Usuario;

public interface UsuarioRepository {

	public boolean comprueba(Usuario usuario) throws Exception;

	public void alta(Usuario usuario);

}
