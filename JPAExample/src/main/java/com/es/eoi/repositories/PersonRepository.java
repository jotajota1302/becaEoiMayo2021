package com.es.eoi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.es.eoi.entities.Person;

public class PersonRepository {

	public EntityManager em;

	// CONSTRUCTOR
	public PersonRepository() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersonPersistenceUnit");
		em = factory.createEntityManager();
	}

	// METODO CREAR CUENTA
	public Person create(Person person) {

		try {
			em.getTransaction().begin();
			em.persist(person);
			em.getTransaction().commit();
			System.out.println("Exito al crear la persona");

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			System.out.println("error al crear la persona");
		}
		
		return person;
		

	}

	// METODO BUSCAR TODOS
	@SuppressWarnings("unchecked")
	public List<Person> findAll() {

		List<Person> result = null;
		try {		
			String hql = "from person";
			Query query = em.createQuery(hql);
			result = query.getResultList();	

		} catch (Exception e) {
			System.out.println("Error al buscar personas");
		}
		return result;
	}	

	// METODO BUSCAR POR ID
	public Person findById(int id) {

		Person person = null;
		try {
			person = em.find(Person.class, id);

		} catch (Exception e) {
			System.out.println("Error al buscar por id");
		}
		return person;
	}

	// METODO MODIFICAR PERSON
	public void update(int id, String name) {

		try {
			Person person = findById(id);
			person.setName(name);
			em.getTransaction().begin();
			em.merge(person);
			em.getTransaction().commit();
			System.out.println("Exito al modificar");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error al modificar");
		}
	}

	// METODO BORRAR 
	public void remove(int id) {

		try {

			Person person = findById(id);
			em.getTransaction().begin();
			em.remove(person);
			em.getTransaction().commit();
			System.out.println("Exito al borrar");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error al borrar");
		}

	}

}
