package edu.es.eoi.flixnet.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "pelicula")
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String nombre;
	
	@Column(name = "estreno")
	@Temporal(TemporalType.DATE)
	private Date fechaEstreno;
	
	@Column(name = "genero")
	private String genero;	
//	
//	private List<Categoria> categoria;
//	
//	private List<Actor> actores;
//	
//	private List<Usuario> usuarios;
	
}
