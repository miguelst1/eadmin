package es.fpdual.eadmin.eadmin.repositorio;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface RepositorioExpediente {

	void altaExpediente(Expediente expediente);
	
	void modificarExpediente(Expediente expediente);
	
	void eliminarExpediente(Integer codigo);
	
	Expediente obtenerExpedientePorCodigo(Integer codigo);
	
	List<Expediente> obtenerTodosLosExpedientes();
}
