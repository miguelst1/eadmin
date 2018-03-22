package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public abstract class ModeloAdministracionElectronica {
	
	private Integer codigo;
	private String nombre;
	private Date fechaCreacion;
	private Boolean publico;
	private Date fechaUltimaModificacion;
	
	public ModeloAdministracionElectronica(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, Date fechaUltimaModificacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.publico = publico;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public Boolean getPublico() {
		return publico;
	}
	
	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	
	@Override
	public int hashCode() {
		return this.codigo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ModeloAdministracionElectronica) {
			return this.codigo.equals(((ModeloAdministracionElectronica) obj).getCodigo());
		}
		return false;
	}
}
