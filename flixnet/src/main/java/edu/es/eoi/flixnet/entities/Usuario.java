package edu.es.eoi.flixnet.entities;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Usuario extends Persona {

	private String usuario;
	private String password;
	private boolean premium;	
	private Date fechaAlta;	
	
	private List<Pelicula> favoritas;

}
