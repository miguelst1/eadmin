package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento_Registro extends Documento{

	private String dniInteresado;
	private String codigoRegistro;
		
	public Documento_Registro(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado,
			String dniInteresado, String codigoRegistro) {
		super(codigo, nombre, fechaCreacion, publico, estado);
		this.dniInteresado = dniInteresado;
		this.codigoRegistro = codigoRegistro;
	}

	public String getDniInteresado() {
		return dniInteresado;
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}
	
	public String toString() {
		return super.toString() + ", Código de Registro: " + codigoRegistro;
	}
}
