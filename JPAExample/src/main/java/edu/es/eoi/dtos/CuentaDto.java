package edu.es.eoi.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CuentaDto {
	
	private String dni;
	
	private String nombreCliente;
	
	private String nombreBanco;

	private double saldo;	

}
