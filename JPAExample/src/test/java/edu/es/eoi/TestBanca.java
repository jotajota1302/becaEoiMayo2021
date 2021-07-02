package edu.es.eoi;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

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
//		Crear 5 Bancos
//		Recuperar un Cliente por su Clave Principal
//		Recuperar un Banco por su Clave Principal
//		Modificaremos un Cliente
//		Modificaremos un Banco
		
		for (int i = 0; i < 5; i++) {			
			Cliente c= new Cliente();
			c.setDni("AAAAAAAA"+i);
			c.setNombre("Cliente TEST");	
			c=repositoryClientes.saveCliente(c);
			clienteIds.add(c.getDni());
		}

		for (String nif : clienteIds) {
			assertNotNull(repositoryClientes.findCliente(nif));
		}		
		
	}
	
	@After
	public void clear() {
		
		for (String nif : clienteIds) {
			repositoryClientes.removeCliente(repositoryClientes.findCliente(nif));
		}
		
	}
	
	
	
	
}
