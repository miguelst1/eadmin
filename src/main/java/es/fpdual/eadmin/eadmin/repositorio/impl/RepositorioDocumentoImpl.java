package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

		altaDocumentoTxt(documento);

		logger.info("El documento con código " + documento.getCodigo() + " se ha creado correctamente");
		logger.info("Saliendo del metodo altaDocumento");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		documentos.set(documentos.indexOf(documento), documento);

		modificarDocumentoTxt(documento);
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		logger.info("Entrando al metodo eliminarDocumento");
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			documentos.remove(documentoEncontrado.get());

			eliminarDocumentoTxt(documentoEncontrado.get());

			logger.info("El documento con codigo " + codigo + " se ha eliminado correctamente");
			logger.info("Saliendo del metodo eliminarDocumento. Documento eliminado");
		} else {
			logger.info("Saliendo del metodo eliminarDocumento. Documento no eliminado");
		}
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

	public void IntroducirDocumentosEnFichero(List<Documento> lista) {
		logger.info("Entrando al metodo IntroducirDocumentosEnFichero");

		String nombreFichero = "documentos.txt";
		File fichero = new File(nombreFichero);
		FileWriter file = null;
		PrintWriter pw = null;

		try {
			if (fichero.exists()) {
				logger.info("Modificando fichero");
			} else {
				logger.info("Creando fichero");
			}
			file = new FileWriter(nombreFichero, true);
			pw = new PrintWriter(file);

			for (Documento d : lista) {
				pw.println("codigo: " + d.getCodigo() + ", nombre: " + d.getNombre() + ", fechaCreacion: "
						+ d.getFechaCreacion() + ", publico: " + d.getPublico() + ", fechaUltimaModificacion: "
						+ d.getFechaUltimaModificacion() + ", estado: " + d.getEstado());
			}
			pw.println("******************************");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		logger.info("Saliendo del metodo IntroducirDocumentosEnFichero");
	}

	public void altaDocumentoTxt(Documento documento) {
		logger.info("Entrando al metodo altaDocumentoTxt");

		String nombreFichero = "alta.txt";
		File fichero = new File(nombreFichero);
		FileWriter file = null;
		PrintWriter pw = null;

		try {
			if (fichero.exists()) {
				logger.info("Modificando fichero");
			} else {
				logger.info("Creando fichero");
			}
			file = new FileWriter(nombreFichero, true);
			pw = new PrintWriter(file);

			pw.println("codigo: " + documento.getCodigo() + ", nombre: " + documento.getNombre() + ", fechaCreacion: "
					+ documento.getFechaCreacion() + ", publico: " + documento.getPublico()
					+ ", fechaUltimaModificacion: " + documento.getFechaUltimaModificacion() + ", estado: "
					+ documento.getEstado());
			pw.println("***********************************");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		logger.info("Saliendo del metodo altaDocumentoTxt");
	}

	public void modificarDocumentoTxt(Documento documento) {
		logger.info("Entrando al metodo modificarDocumentoTxt");

		String nombreFichero = "modificar.txt";
		File fichero = new File(nombreFichero);
		FileWriter file = null;
		PrintWriter pw = null;

		try {
			if (fichero.exists()) {
				logger.info("Modificando fichero");
			} else {
				logger.info("Creando fichero");
			}
			file = new FileWriter(nombreFichero, true);
			pw = new PrintWriter(file);

			pw.println("codigo: " + documento.getCodigo() + ", nombre: " + documento.getNombre() + ", fechaCreacion: "
					+ documento.getFechaCreacion() + ", publico: " + documento.getPublico()
					+ ", fechaUltimaModificacion: " + documento.getFechaUltimaModificacion() + ", estado: "
					+ documento.getEstado());
			pw.println("***********************************");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		logger.info("Saliendo del metodo modificarDocumentoTxt");
	}

	public void eliminarDocumentoTxt(Documento documento) {
		logger.info("Entrando al metodo eliminarDocumentoTxt");

		String nombreFichero = "eliminar.txt";
		File fichero = new File(nombreFichero);
		FileWriter file = null;
		PrintWriter pw = null;

		try {
			if (fichero.exists()) {
				logger.info("Modificando fichero");
			} else {
				logger.info("Creando fichero");
			}
			file = new FileWriter(nombreFichero, true);
			pw = new PrintWriter(file);

			pw.println("codigo: " + documento.getCodigo() + ", nombre: " + documento.getNombre() + ", fechaCreacion: "
					+ documento.getFechaCreacion() + ", publico: " + documento.getPublico()
					+ ", fechaUltimaModificacion: " + documento.getFechaUltimaModificacion() + ", estado: "
					+ documento.getEstado());
			pw.println("***********************************");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		logger.info("Saliendo del metodo eliminarDocumentoTxt");
	}

}
