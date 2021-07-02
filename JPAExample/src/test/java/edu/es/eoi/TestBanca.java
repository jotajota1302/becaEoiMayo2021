package edu.es.eoi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.es.eoi.entities.Banco;
import com.es.eoi.entities.Cliente;
import com.es.eoi.repositories.BancoRepositoryJPAImpl;
import com.es.eoi.repositories.ClienteRepositoryJPAImpl;

public class TestBanca {

	ClienteRepositoryJPAImpl repositoryClientes= new ClienteRepositoryJPAImpl();
	
	BancoRepositoryJPAImpl repositoryBancos= new BancoRepositoryJPAImpl();

	List<Integer> bancoIds=new ArrayList<Integer>();	 
	List<String> clienteIds=new ArrayList<String>();	 

	@Test
	public void ejercicios() {			
	
//		Crear 5 Clientes
		
		for (int i = 0; i < 5; i++) {			
			Cliente c= new Cliente();
			c.setDni("AAAAAAAA"+i);
			c.setNombre("Cliente TEST");	
			c=repositoryClientes.saveCliente(c);
			clienteIds.add(c.getDni());
		}

		for (String nif : clienteIds) {
//			Recuperar un Cliente por su Clave Principal
			assertNotNull(repositoryClientes.findCliente(nif));
		}		
		
//		Crear 5 Bancos
		
		for (int i = 0; i < 5; i++) {			
			Banco b= new Banco();			
			b.setNombre("Banco TEST" + i);	
			b=repositoryBancos.saveBanco(b);
			bancoIds.add(b.getId());
		}

		for (int id : bancoIds) {
//			Recuperar un Banco por su Clave Principal
			assertNotNull(repositoryBancos.findBanco(id));
		}		
		
//		Modificaremos un Cliente
				
		Cliente c=repositoryClientes.findCliente("AAAAAAAA1");
		c.setDireccion("DIRECCION_TEST");		
		repositoryClientes.updateCliente(c);
		
		assertEquals("DIRECCION_TEST",repositoryClientes.findCliente("AAAAAAAA1").getDireccion());
		
//		Modificaremos un Banco
		
		Banco b=repositoryBancos.findBanco(1);
		b.setCiudad("CIUDAD_TEST");
		repositoryBancos.updateBanco(b);
		
		assertEquals("CIUDAD_TEST",repositoryBancos.findBanco(1).getCiudad());
		
	}
	
	@After
	public void clear() {
		
		for (String nif : clienteIds) {
			repositoryClientes.removeCliente(repositoryClientes.findCliente(nif));
		}
		
		for (int id : bancoIds) {
			repositoryBancos.removeBanco(repositoryBancos.findBanco(id));
		}
		
	}
	
	
	
	
}
