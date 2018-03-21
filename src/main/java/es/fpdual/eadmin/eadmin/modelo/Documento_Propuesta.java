package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento_Propuesta extends Documento{
	
	private Integer codigoPropuesta;
	private Integer ejercicio;
	private String grupoPolitico;
	
	public Documento_Propuesta(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado,
			Integer codigoPropuesta, Integer ejercicio, String grupoPolitico) {
		super(codigo, nombre, fechaCreacion, publico, estado);
		this.codigoPropuesta = codigoPropuesta;
		this.ejercicio = ejercicio;
		this.grupoPolitico = grupoPolitico;
	}

	public Integer getCodigoPropuesta() {
		return codigoPropuesta;
	}

	public Integer getEjercicio() {
		return ejercicio;
	}

	public String getGrupoPolitico() {
		return grupoPolitico;
	}
	
	public String toString() {
		return super.toString() + " Código de Propuesta: " + codigoPropuesta;
	}
}