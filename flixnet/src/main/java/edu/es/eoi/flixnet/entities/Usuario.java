package edu.es.eoi.flixnet.entities;

import java.util.Date;

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

}
