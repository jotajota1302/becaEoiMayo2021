package edu.es.eoi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.es.eoi.entities.Cliente;
import edu.es.eoi.repositories.ClienteRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest
public class TestClienteRepository {

	@Autowired
	ClienteRepository repository;	
	
	@Before
	public void initData() {
		
		repository.save(new Cliente("19082371E","Jose", "C/TEST"));	
		repository.save(new Cliente("03765983S","JJ", "direccion"));
		
	}

	@Test
	public void testFindCliente() {	
		
		Cliente cliente=repository.findById("03765983S").get();				
		List<Cliente> clientes=repository.findByNombre("JJ");		
		
		assertEquals("JJ",cliente.getNombre());
		assertEquals(1,clientes.size());	
		
		clientes=repository.findByDniEndingWith("S");
		assertEquals(1,clientes.size());	
		
	}
	
	@After
	public void clear() {		
		repository.deleteAll();
	}
	
}
