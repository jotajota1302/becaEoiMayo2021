package edu.es.eoi.flixnetspring.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actor extends Persona {

	@Column
	private int oscars;
	
	@ManyToMany(targetEntity = Pelicula.class)
	List<Pelicula> peliculas;

	

}
