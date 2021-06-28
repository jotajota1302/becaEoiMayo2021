package edu.es.eoi.flixnet.repository;

import java.util.ArrayList;
import java.util.List;

import edu.es.eoi.flixnet.entities.Usuario;

public class UsuarioRepositoryMemoryImpl implements UsuarioRepository {

	public static List<Usuario> usuarios = new ArrayList<Usuario>();

	public UsuarioRepositoryMemoryImpl() {

		Usuario usuario1 = new Usuario("Pepe", "123456");
		Usuario usuario2 = new Usuario("Maria", "111111");
		usuarios.add(usuario1);
		usuarios.add(usuario2);

	}

	@Override
	public boolean comprueba(Usuario usuario) {

		return usuarios.contains(usuario);

	}

	@Override
	public void alta(Usuario usuario) {

		usuarios.add(usuario);

	}

}
