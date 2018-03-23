package es.fpdua.eadmin.eadmin.modelo.builder;

import java.math.BigDecimal;

import es.fpdual.eadmin.eadmin.modelo.DocumentoContable;

public class DocumentoContableBuilder extends DocumentoBuilder {
	
	private BigDecimal importe;
	private String dniInteresado;
	
	public DocumentoContable construir() {
		return new DocumentoContable(this.codigo, this.nombre, this.fechaCreacion,
				this.publico, this.estado, this.fechaUltimaModificacion,
				this.importe, this.dniInteresado);
	}
	
	public DocumentoContableBuilder conImporte(BigDecimal importe) {
		this.importe = importe;
		return this;
	}
	
	public DocumentoContableBuilder conDniInteresado(String dniInteresado) {
		this.dniInteresado = dniInteresado;
		return this;
	}
	
	public DocumentoContableBuilder clonar(DocumentoContable documentoContable) {
		super.clonar(documentoContable);
		this.importe = documentoContable.getImporte();
		this.dniInteresado = documentoContable.getDni_Interesado();
		return this;
	}
}
