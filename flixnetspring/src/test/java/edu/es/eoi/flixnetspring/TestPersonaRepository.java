package edu.es.eoi.flixnetspring;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.es.eoi.flixnetspring.entities.Actor;
import edu.es.eoi.flixnetspring.entities.Persona;
import edu.es.eoi.flixnetspring.entities.Usuario;
import edu.es.eoi.flixnetspring.repositories.PersonaRepository;
import edu.es.eoi.flixnetspring.repositories.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPersonaRepository {

	@Autowired
	PersonaRepository repository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	public void testFindPersona() {	
		
		//prepare
		
		Usuario user= new Usuario();
		user.setUser("ADMIN");
		user.setPassword("AAAAAA");
		user.setNombre("JJ");
		user.setMail("jj@jj.com");
		
		repository.save(user);
		
		Actor actor= new Actor();
		actor.setNombre("Marlon Brando");
		actor.setOscars(2);
		
		repository.save(actor);
		
		//act
		
		Persona p1=this.repository.findByNombre("JJ");
		
		Usuario p2=this.usuarioRepository.findByUser("ADMIN");
		
		//assert
		
		assertEquals("JJ",p1.getNombre());
		assertEquals(Usuario.class,p1.getClass());
		
		assertEquals("ADMIN",p2.getUser());
		assertEquals(Usuario.class,p2.getClass());
		
	}

}