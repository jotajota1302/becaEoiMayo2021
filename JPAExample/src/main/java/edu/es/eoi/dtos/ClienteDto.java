package edu.es.eoi.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

	private String dni;

	private String nombre;

	private String direccion;	
	
	private Double saldoTotal;
	
	private Date fechaAlta;
	

}
