package edu.es.eoi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "edu.es.eoi.repositories")
@EntityScan(basePackages = "edu.es.eoi.entities")
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
	
	
	@Bean(name = "myEM")
	public EntityManager getEntityManager() {		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BancoPersistenceUnit");
		return factory.createEntityManager();
		
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
