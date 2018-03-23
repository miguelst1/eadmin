package es.fpdual.eadmin.eadmin.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class DocumentoContable extends Documento{
	
	private final BigDecimal importe;
	private final String dniInteresado;
	
	public DocumentoContable(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado,
			Date fechaUltimaModificacion, BigDecimal importe, String dniInteresado) {
		super(codigo, nombre, fechaCreacion, publico, estado, fechaUltimaModificacion);
		this.importe = importe;
		this.dniInteresado = dniInteresado;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public String getDni_Interesado() {
		return dniInteresado;
	}
	
	public String toString() {
		return super.toString() + ", Importe: " + importe;
	}
}
