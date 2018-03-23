package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoRegistro extends Documento{

	private final String dniInteresado;
	private final String codigoRegistro;
		
	public DocumentoRegistro(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado,
			Date fechaUltimaModificacion, String dniInteresado, String codigoRegistro) {
		super(codigo, nombre, fechaCreacion, publico, estado, fechaUltimaModificacion);
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
