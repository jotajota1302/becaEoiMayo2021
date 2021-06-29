package edu.es.eoi.flixnet.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Persona {

	private String nombre;
	private String apellidos;
	private String mail;
}
