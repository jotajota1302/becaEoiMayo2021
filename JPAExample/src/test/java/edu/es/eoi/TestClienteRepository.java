package edu.es.eoi;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.es.eoi.repositories.ClienteRepositoryJPAImpl;

public class TestClienteRepository {

	ClienteRepositoryJPAImpl repository= new ClienteRepositoryJPAImpl();
	List<Integer> ids=new ArrayList<Integer>();	 

	@Test
	public void testFindCliente() {	
		
		assertNotNull(repository.findCliente("03765983S"));
		
	}
	
	
}
