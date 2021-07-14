package edu.es.eoi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import edu.es.eoi.entities.Cliente;
import edu.es.eoi.entities.Cuenta;
import edu.es.eoi.repositories.ClienteRepository;

@SpringBootTest
@ContextConfiguration(classes = MainApp.class)
public class TestClienteRepository {

	@Autowired
	ClienteRepository repository;	

	@Test
	public void testFindCliente() {	
		
		Cliente cliente=repository.findById("03765983S").get();
		
		List<Cuenta> cuentas=cliente.getCuentas();
		
		assertEquals("juan",cliente.getNombre());
		assertEquals(1,cuentas.size());		
		
	}
	
	
}
