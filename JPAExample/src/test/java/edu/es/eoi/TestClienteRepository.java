package edu.es.eoi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.es.eoi.entities.Cliente;
import edu.es.eoi.repositories.ClienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestClienteRepository {

	@Autowired
	ClienteRepository repository;	

	@Test
	public void testFindCliente() {	
		
		Cliente cliente=repository.findById("03765983S").get();
				
		assertEquals("juan",cliente.getNombre());
	
		
	}
	
	
}
