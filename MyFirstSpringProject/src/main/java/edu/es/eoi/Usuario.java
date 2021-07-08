package edu.es.eoi;

import org.springframework.beans.factory.annotation.Autowired;

public class Usuario {
	
	private String nombre;
	
	@Autowired
	private Perro perro;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Perro getPerro() {
		return perro;
	}

	public void setPerro(Perro perro) {
		this.perro = perro;
	}

	

}
