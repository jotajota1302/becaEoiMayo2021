package com.es.eoi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "person")
@Getter
@Setter
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;

	@Column
	private String surname;
	
	@Column
	private String mail;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL, optional = false)
	private Address address;
				
	public Person() {

	}

}
