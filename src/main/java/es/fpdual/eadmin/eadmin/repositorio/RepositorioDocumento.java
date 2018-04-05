package es.fpdual.eadmin.eadmin.repositorio;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface RepositorioDocumento {

	void altaDocumento(Documento documento);

	void modificarDocumento(Documento documento);

	void eliminarDocumento(Integer codigo);

	Documento obtenerDocumentoPorCodigo(Integer codigo);

	List<Documento> obtenerTodosLosDocumentos();

	void IntroducirDocumentosEnFichero(List<Documento> lista);
}
