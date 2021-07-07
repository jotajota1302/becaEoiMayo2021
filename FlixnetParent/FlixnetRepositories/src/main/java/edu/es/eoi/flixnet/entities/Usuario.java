package edu.es.eoi.flixnet.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Usuario extends Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	@Column
	private String usuario;
	@Column
	private String password;
	@Column
	private boolean premium;	
	@Column(name = "alta")
	private Date fechaAlta;	
	

}
