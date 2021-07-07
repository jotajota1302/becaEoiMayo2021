package edu.es.eoi;

import edu.es.eoi.flixnet.entities.Usuario;
import edu.es.eoi.flixnet.repository.UsuarioRepositoryJPAImpl;

public class UsuarioService {

	UsuarioRepositoryJPAImpl repository = new UsuarioRepositoryJPAImpl();

	public boolean login(String user, String password) {

		Usuario usuario = repository.find(user);

		if (usuario != null) {

			if (usuario.getPassword().equals(password)) {
				return true;
			} else {
				System.out.println("Contraseña incorrecta");
				return false;
			}
		}
		{
			System.out.println("Usuario no encontrado");
			return false;
		}

	}

}
