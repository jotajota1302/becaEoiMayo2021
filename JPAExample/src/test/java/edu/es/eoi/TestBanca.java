package edu.es.eoi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.es.eoi.entities.Banco;
import com.es.eoi.entities.Cliente;
import com.es.eoi.entities.Cuenta;
import com.es.eoi.repositories.BancoRepositoryJPAImpl;
import com.es.eoi.repositories.ClienteRepositoryJPAImpl;
import com.es.eoi.repositories.CuentaRepositoryJPAImpl;

public class TestBanca {

	ClienteRepositoryJPAImpl repositoryClientes = new ClienteRepositoryJPAImpl();

	BancoRepositoryJPAImpl repositoryBancos = new BancoRepositoryJPAImpl();
	
	CuentaRepositoryJPAImpl repositoryCuentas=new CuentaRepositoryJPAImpl();

	List<Integer> bancoIds = new ArrayList<Integer>();
	List<String> clienteIds = new ArrayList<String>();

	@Test
	public void ejercicios() {
		
		
		try {			
		

//		Crear 5 Clientes

		for (int i = 0; i < 5; i++) {
			Cliente c = new Cliente();
			c.setDni("AAAAAAAA" + i);
			c.setNombre("Cliente TEST");
			c = repositoryClientes.saveCliente(c);
			clienteIds.add(c.getDni());
		}

		for (String nif : clienteIds) {
//			Recuperar un Cliente por su Clave Principal
			assertNotNull(repositoryClientes.findCliente(nif));
		}

//		Crear 5 Bancos

		for (int i = 0; i < 5; i++) {
			Banco b = new Banco();
			b.setNombre("Banco TEST" + i);
			b = repositoryBancos.saveBanco(b);
			bancoIds.add(b.getId());
		}

		for (int id : bancoIds) {
//			Recuperar un Banco por su Clave Principal
			assertNotNull(repositoryBancos.findBanco(id));
		}

//		Modificaremos un Cliente

		Cliente c = repositoryClientes.findCliente("AAAAAAAA1");
		c.setDireccion("DIRECCION_TEST");
		repositoryClientes.updateCliente(c);

		assertEquals("DIRECCION_TEST", repositoryClientes.findCliente("AAAAAAAA1").getDireccion());

//		Modificaremos un Banco

		Banco b = repositoryBancos.findBanco(1);
		b.setCiudad("CIUDAD_TEST");
		repositoryBancos.updateBanco(b);

		assertEquals("CIUDAD_TEST", repositoryBancos.findBanco(1).getCiudad());
		
		assertNotNull(repositoryClientes.findAll());		
		assertNotNull(repositoryBancos.findAll());
		
		
		//crear una cuenta
		
		Cuenta cuenta=new Cuenta();
		cuenta.setSaldo(300);
		
		Cliente cliente = repositoryClientes.findCliente("AAAAAAAA1");
		
		cuenta.setCliente(cliente);		
		
		if(cliente.getCuentas()!=null) {
			cliente.getCuentas().add(cuenta);
		}else {
			cliente.setCuentas(new ArrayList<Cuenta>());
			cliente.getCuentas().add(cuenta);
		}		
		
		Banco banco= repositoryBancos.findBanco(1);
		
		cuenta.setBanco(banco);
		
		if(banco.getCuentas()!=null) {
			banco.getCuentas().add(cuenta);
		}else {
			banco.setCuentas(new ArrayList<>());
			banco.getCuentas().add(cuenta);
		}		
		
		assertNotNull(repositoryCuentas.saveCuenta(cuenta));
		
		} catch (Exception e) {
			
			clear();
		}

	}

	@After
	public void clear() {
// 		Eliminaremos un Cliente

		for (String nif : clienteIds) {
			repositoryClientes.removeCliente(repositoryClientes.findCliente(nif));
		}
//		Eliminaremos un Banco
		
		for (int id : bancoIds) {
			repositoryBancos.removeBanco(repositoryBancos.findBanco(id));
		}

	}

}
