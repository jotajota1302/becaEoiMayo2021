package edu.es.eoi.flixnet.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Actor extends Persona {

	private int totalPeliculas;

}
