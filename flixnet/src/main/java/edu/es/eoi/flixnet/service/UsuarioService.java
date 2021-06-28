package edu.es.eoi.flixnet.service;

import edu.es.eoi.flixnet.entities.Usuario;
import edu.es.eoi.flixnet.repository.UsuarioRepository;
import edu.es.eoi.flixnet.repository.UsuarioRepositoryFileTextImpl;

public class UsuarioService {

	private UsuarioRepository repository = new UsuarioRepositoryFileTextImpl();

	public boolean comprueba(Usuario usuario) {
	
		System.out.println("compruebo usuario:" + this.getClass().getSimpleName());
		
		return this.repository.comprueba(usuario);
	};

	public void alta(Usuario usuario) {
		
		System.out.println("alta usuario:" + this.getClass().getSimpleName());
		this.repository.alta(usuario);

	};

}
