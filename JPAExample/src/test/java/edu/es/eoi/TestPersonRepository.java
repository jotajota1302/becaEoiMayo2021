package edu.es.eoi;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.es.eoi.entities.Address;
import com.es.eoi.entities.Person;
import com.es.eoi.repositories.PersonRepository;

public class TestPersonRepository {

	PersonRepository repository;
	
	Logger logger=Logger.getLogger(TestPersonRepository.class);
	
	@Before
	public void setUp() throws Exception {
		
		Logger log = Logger.getLogger("org.hibernate.SQL");
		log.setLevel(Level.DEBUG);	
		repository= new PersonRepository();		
		
	}
	
	@After
	public void clear() {		
		repository.findAll().forEach(p->{
			repository.remove(p.getId());
		});	
	}

	@Test
	public void testCreate() {
		
		Address adress= new Address();		
		adress.setAddress("C/pueblo acantilao");				
		
		Person person= new Person();
		person.setName("PEPE");
		person.setSurname("PERICO");	
		
		adress.setPerson(person);		
		person.setAddress(adress);
				
		repository.create(person);
	}

	@Test
	public void testFindAll() {		
		
		assertNotNull(repository.findAll());		
		
	}

	@Test
	public void testFindById() {
		

		Address adress= new Address();		
		adress.setAddress("C/pueblo acantilao");				
		
		Person person= new Person();
		person.setName("PEPE");
		person.setSurname("PERICO");	
		
		adress.setPerson(person);		
		person.setAddress(adress);
				
		person=repository.create(person);		
				
		assertNotNull(repository.findById(person.getId()));
		
	}

	
	
}
