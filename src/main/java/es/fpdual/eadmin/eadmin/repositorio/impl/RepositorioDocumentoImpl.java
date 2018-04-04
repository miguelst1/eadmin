package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private static final Logger logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);

	private final List<Documento> documentos = new ArrayList<>();

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public void altaDocumento(Documento documento) {
		logger.info("Entrando al metodo altaDocumento");
		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}
		documentos.add(documento);
		logger.info("El documento con código " + documento.getCodigo() + " se ha creado correctamente");
		logger.info("Saliendo del metodo altaDocumento");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		documentos.set(documentos.indexOf(documento), documento);
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		logger.info("Entrando al metodo eliminarDocumento");
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			documentos.remove(documentoEncontrado.get());
			logger.info("El documento con codigo " + codigo + " se ha eliminado correctamente");
			logger.info("Saliendo del metodo eliminarDocumento. Documento eliminado");
		}
		logger.info("Saliendo del metodo eliminarDocumento. Documento no eliminado");
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		logger.info("Entrando al metodo obtenerDocumentoPorCodigo");
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			logger.info("Saliendo del metodo obtenerDocumentoPorCodigo. Documento encontrado");
			return documentoEncontrado.get();
		}
		logger.info("Saliendo del metodo obtenerDocumentoPorCodigo. Documento no encontrado");
		return null;
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		logger.info("Entrando al metodo obtenerTodosLosDocumentos");
		for (Documento d : getDocumentos()) {
			logger.info("codigo: " + d.getCodigo() + ", nombre: " + d.getNombre() + ", fechaCreacion: "
					+ d.getFechaCreacion() + ", publico: " + d.getPublico() + ", fechaUltimaModificacion: "
					+ d.getFechaUltimaModificacion() + ", estado: " + d.getEstado());
		}
		logger.info("Saliendo del metodo obtenerTodosLosDocumentos");
		return getDocumentos();
	}

}
