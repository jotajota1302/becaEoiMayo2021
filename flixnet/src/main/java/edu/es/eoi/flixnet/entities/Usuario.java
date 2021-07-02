package edu.es.eoi.flixnet.entities;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
public class Usuario extends Persona {

	private String usuario;
	private String password;
	private boolean premium;	
	private Date fechaAlta;	
	
	private List<Pelicula> favoritas;

}
