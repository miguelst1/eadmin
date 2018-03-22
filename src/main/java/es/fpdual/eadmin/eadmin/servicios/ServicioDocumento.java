package es.fpdual.eadmin.eadmin.servicios;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface ServicioDocumento {

	Documento altaDocumento(Documento documento);
	
	Documento modificarDocumento(Documento documento);
	
	void eliminarDocumento(Integer codigo);
}
