package es.fpdual.eadmin.eadmin.modelo;

import java.util.List;
import java.util.Date;

public class Expediente extends ModeloAdministracionElectronica {

	private Date fechaArchivado;
	private EstadoExpediente estado;
	private List<Documento> documentos;

	public Expediente(Integer codigo, String nombre, Date fechaCreacion, Date fechaArchivado, Boolean publico,
			EstadoExpediente estado, Date fechaUltimaModificacion, List<Documento> documentos) {
		super(codigo, nombre, fechaCreacion, publico, fechaUltimaModificacion);
		this.fechaArchivado = fechaArchivado;
		this.estado = estado;
		this.documentos = documentos;
	}

	public Date getFechaArchivado() {
		return fechaArchivado;
	}

	public EstadoExpediente getEstado() {
		return estado;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public int hashCode() {
		return getCodigo().hashCode() + getNombre().hashCode() + getFechaCreacion().hashCode() + fechaArchivado.hashCode()
				+ getPublico().hashCode() + estado.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Expediente) {
			return getCodigo().equals(((Expediente) obj).getCodigo()) && getNombre().equals(((Expediente) obj).getNombre())
					&& getFechaCreacion().equals(((Expediente) obj).getFechaCreacion())
					&& fechaArchivado.equals(((Expediente) obj).getFechaArchivado())
					&& getPublico().equals(((Expediente) obj).getPublico()) && estado.equals(((Expediente) obj).getEstado());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Expediente " + getCodigo();
	}

}
