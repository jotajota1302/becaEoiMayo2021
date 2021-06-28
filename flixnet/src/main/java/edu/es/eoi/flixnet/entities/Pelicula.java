package edu.es.eoi.flixnet.entities;

import java.util.Date;

public class Pelicula {

	private String nombre;
	private Date fechaEstreno;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

}
