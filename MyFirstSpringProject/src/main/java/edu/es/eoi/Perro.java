package edu.es.eoi;

import org.springframework.stereotype.Component;

@Component
public class Perro {
	
	private String raza;

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	

}
