package edu.es.eoi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
	
	
	@Bean
	public EntityManager getEntityManager() {		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BancoPersistenceUnit");
		return factory.createEntityManager();
		
	}

}
