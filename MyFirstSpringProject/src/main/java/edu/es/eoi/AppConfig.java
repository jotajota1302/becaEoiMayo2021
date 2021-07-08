package edu.es.eoi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {	
	
	@Bean
	public Usuario getUsuario() {		
		return new Usuario("PEPE");		
	}
	
	@Bean
	public Perro getPerro() {		
		return new Perro("Pastor Aleman");		
	}

}
