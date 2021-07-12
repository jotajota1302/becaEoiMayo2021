package edu.es.eoi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CUENTAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cuenta {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "saldo")
	private int saldo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDBANCO", referencedColumnName = "ID")
	private Banco banco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DNI", referencedColumnName = "DNI")
	private Cliente cliente;

}
