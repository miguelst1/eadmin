package es.fpdual.eadmin.eadmin.servicios;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface ServicioExpediente {
	
	Expediente altaExpediente(Expediente expediente);
	
	Expediente modificarExpediente(Expediente expediente);
	
	void eliminarExpediente(Integer codigoExpediente);
	
	Expediente asociarDocumentoAlExpediente(Integer codigoExpediente, Documento documento);
	
	Expediente desasociarDocumentoDelExpediente(Integer codigoExpediente, Integer codigoDocumento);
	
	Expediente obtenerExpedientePorCodigo(Integer codigo);
	
	List<Expediente> obtenerTodosLosExpedientes();
}
