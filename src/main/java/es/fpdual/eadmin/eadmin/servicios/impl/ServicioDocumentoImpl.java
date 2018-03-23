package es.fpdual.eadmin.eadmin.servicios.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdua.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicios.ServicioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento{

	private final RepositorioDocumento repositorioDocumento;
	
	@Autowired
	public ServicioDocumentoImpl (RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}
	
	@Override
	public Documento altaDocumento(Documento documento) {
		final Documento documentoAlta = obtenerDocumentoConFechaCorrectaAlta(documento);
		
		repositorioDocumento.altaDocumento(documentoAlta);
		return documentoAlta;
	}

	@Override
	public Documento modificarDocumento(Documento documento) {
		final Documento documentoModificado = obtenerDocumentoConFechaCorrectaModificar(documento);
		
		repositorioDocumento.modificarDocumento(documentoModificado);
		return documentoModificado;
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		repositorioDocumento.eliminarDocumento(codigo);
	}
	
	protected Date dameFechaActual() {
		return new Date();
	}
	
	public Documento obtenerDocumentoConFechaCorrectaAlta(Documento documento) {	
		return new DocumentoBuilder().clonar(documento).conFechaCreacion(dameFechaActual()).construir();
	}
	
	public Documento obtenerDocumentoConFechaCorrectaModificar(Documento documento) {
		return new Documento(documento.getCodigo(),
				documento.getNombre(), documento.getFechaCreacion(), documento.getPublico(),
				documento.getEstado(), dameFechaActual());
	}
}
