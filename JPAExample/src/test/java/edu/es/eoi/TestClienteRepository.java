package edu.es.eoi;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.es.eoi.entities.Cliente;
import edu.es.eoi.entities.Cuenta;
import edu.es.eoi.repositories.ClienteRepository;
import edu.es.eoi.repositories.ClienteRepositoryJPAImpl;

public class TestClienteRepository {

	ClienteRepository repository= new ClienteRepositoryJPAImpl();
	List<Integer> ids=new ArrayList<Integer>();	 

	@Test
	public void testFindCliente() {	
		
		Cliente cliente=repository.findCliente("03765983S");
		
		List<Cuenta> cuentas=cliente.getCuentas();
		
		assertEquals("juan",cliente.getNombre());
		assertEquals(1,cuentas.size());
		
	}
	
	
}
