package edu.es.eoi.dtos;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ClienteDto {

	private String dni;

	private String nombre;

	private String direccion;	
	
	private Double saldoTotal;

}
