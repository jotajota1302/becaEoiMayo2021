package edu.es.eoi.flixnet.entities;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Pelicula {

	private String nombre;
	private Date fechaEstreno;
	private GeneroEnum genero;
	
}
