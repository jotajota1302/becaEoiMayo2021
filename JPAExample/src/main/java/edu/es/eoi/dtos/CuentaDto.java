package edu.es.eoi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDto {
	
	private String dni;
	
	private String nombreCliente;
	
	private String nombreBanco;

	private double saldo;	

}
