package edu.es.eoi.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BancoDto {

	private String nombre;

	private String ciudad;

	private List<CuentaDto> cuentas;

}
