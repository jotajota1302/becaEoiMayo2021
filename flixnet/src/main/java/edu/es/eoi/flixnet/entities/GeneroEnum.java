package edu.es.eoi.flixnet.entities;

import lombok.Getter;

@Getter
public enum GeneroEnum {		
	
	ACCION(1,"Acción"),COMEDIA(2,"Comedia"),AMOR(3,"Romántico"),FANTASIA(4,"Fantástico"),MARVEL(5,"Super Héroes");
	
	private int codigo;	
	private String descripcion;

	private GeneroEnum(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}	
	
	public static GeneroEnum getNombreBycodigo(int codigo) {		
		
		for (GeneroEnum generoEnum : GeneroEnum.values()) {
			
			if(generoEnum.getCodigo()==codigo) {
				return generoEnum;
			}
			
		}
		
		return null;		
		
	}
	
}
