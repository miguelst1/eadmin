package es.fpdual.eadmin.eadmin.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class Documento_Contable extends Documento{
	
	private BigDecimal importe;
	private String dni_Interesado;
	
	public Documento_Contable(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado,
			BigDecimal importe, String dni_Interesado) {
		super(codigo, nombre, fechaCreacion, publico, estado);
		this.importe = importe;
		this.dni_Interesado = dni_Interesado;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public String getDni_Interesado() {
		return dni_Interesado;
	}
	
	public String toString() {
		return super.toString() + ", Importe: " + importe;
	}
}
