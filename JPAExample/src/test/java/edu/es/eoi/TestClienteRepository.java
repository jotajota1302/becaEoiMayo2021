package edu.es.eoi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.Calendar;
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
		
		Cliente c1=new Cliente("19082371E","Jose", "C/TEST");
		c1.setFechaAlta(new Date(Calendar.getInstance().getTimeInMillis()));
		
		Cliente c2=new Cliente("03765983S","JJ", "direccion");
		c2.setFechaAlta(new Date(Calendar.getInstance().getTimeInMillis()));
				
		repository.save(c1);			
		repository.save(c2);
		
	}

	@Test
	public void testFindCliente() {	
		
		Cliente cliente=repository.findById("03765983S").get();				
		List<Cliente> clientes=repository.findByNombre("JJ");		
		
		assertEquals("JJ",cliente.getNombre());
		assertEquals(1,clientes.size());	
		assertNotNull(cliente.getFechaAlta());	
		
		clientes=repository.findByDniEndingWith("S");
		assertEquals(1,clientes.size());	
		
	}
	
	@After
	public void clear() {		
		repository.deleteAll();
	}
	
}
