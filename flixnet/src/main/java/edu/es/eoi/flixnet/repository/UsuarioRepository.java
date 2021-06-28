package edu.es.eoi.flixnet.repository;

import edu.es.eoi.flixnet.entities.Usuario;

public interface UsuarioRepository {

	public boolean comprueba(Usuario usuario);

	public void alta(Usuario usuario);

}
