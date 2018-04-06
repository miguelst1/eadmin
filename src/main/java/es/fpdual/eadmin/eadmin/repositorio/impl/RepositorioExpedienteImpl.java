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

import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

@Repository
public class RepositorioExpedienteImpl implements RepositorioExpediente {

	private final List<Expediente> expedientes = new ArrayList<>();
	private static final Logger logger = LoggerFactory.getLogger(RepositorioExpedienteImpl.class);

	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	@Override
	public void altaExpediente(Expediente expediente) {
		logger.info("Entrando al metodo altaExpediente");
		if (expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente ya existe");
		}
		expedientes.add(expediente);

		altaExpedienteTxt(expediente);

		System.out.println("El expediente se ha insertado correctamente");

		logger.info("Saliendo del metodo altaExpediente");
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		logger.info("Entrando al metodo modificarExpediente");
		if (!expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		expedientes.set(expedientes.indexOf(expediente), expediente);

		modificarExpedienteTxt(expediente);

		logger.info("Saliendo del metodo modificarExpediente");
	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		logger.info("Entrando al metodo eliminarExpediente");
		Optional<Expediente> expedienteEncontrado = expedientes.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();

		if (expedienteEncontrado.isPresent()) {
			expedientes.remove(expedienteEncontrado.get());

			eliminarExpedienteTxt(expedienteEncontrado.get());
		}

		logger.info("Saliendo del metodo eliminarExpediente");
	}

	@Override
	public Expediente obtenerExpedientePorCodigo(Integer codigo) {
		Optional<Expediente> expedienteEncontrado = expedientes.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();

		if (expedienteEncontrado.isPresent()) {
			return expedienteEncontrado.get();
		}

		return null;
	}

	@Override
	public List<Expediente> obtenerTodosLosExpedientes() {
		return getExpedientes();
	}

	public void altaExpedienteTxt(Expediente expediente) {
		logger.info("Entrando al metodo altaExpedienteTxt");

		String nombreFichero = "altaE.txt";
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

			pw.println("codigo: " + expediente.getCodigo() + ", nombre: " + expediente.getNombre() + ", fechaCreacion: "
					+ expediente.getFechaCreacion() + ", publico: " + expediente.getPublico()
					+ ", fechaUltimaModificacion: " + expediente.getFechaUltimaModificacion() + ", estado: "
					+ expediente.getEstado() + ", fechaArchivado: " + expediente.getFechaArchivado() + ", documentos: "
					+ expediente.getDocumentos());
			pw.println("***********************************");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		logger.info("Saliendo del metodo altaExpedienteTxt");
	}

	public void modificarExpedienteTxt(Expediente expediente) {
		logger.info("Entrando al metodo modificarExpedienteTxt");

		String nombreFichero = "modificarE.txt";
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

			pw.println("codigo: " + expediente.getCodigo() + ", nombre: " + expediente.getNombre() + ", fechaCreacion: "
					+ expediente.getFechaCreacion() + ", publico: " + expediente.getPublico()
					+ ", fechaUltimaModificacion: " + expediente.getFechaUltimaModificacion() + ", estado: "
					+ expediente.getEstado() + ", fechaArchivado: " + expediente.getFechaArchivado() + ", documentos: "
					+ expediente.getDocumentos());
			pw.println("***********************************");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		logger.info("Saliendo del metodo modificarExpedienteTxt");
	}

	public void eliminarExpedienteTxt(Expediente expediente) {
		logger.info("Entrando al metodo eliminarExpedienteTxt");

		String nombreFichero = "eliminarE.txt";
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

			pw.println("codigo: " + expediente.getCodigo() + ", nombre: " + expediente.getNombre() + ", fechaCreacion: "
					+ expediente.getFechaCreacion() + ", publico: " + expediente.getPublico()
					+ ", fechaUltimaModificacion: " + expediente.getFechaUltimaModificacion() + ", estado: "
					+ expediente.getEstado() + ", fechaArchivado: " + expediente.getFechaArchivado() + ", documentos: "
					+ expediente.getDocumentos());
			pw.println("***********************************");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		logger.info("Saliendo del metodo eliminarExpedienteTxt");
	}

	public void IntroducirExpedientesEnFichero(List<Expediente> lista) {
		logger.info("Entrando al metodo IntroducirExpedienteEnFichero");

		String nombreFichero = "expedientes.txt";
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

			for (Expediente e : lista) {
				pw.println("codigo: " + e.getCodigo() + ", nombre: " + e.getNombre() + ", fechaCreacion: "
						+ e.getFechaCreacion() + ", publico: " + e.getPublico() + ", fechaUltimaModificacion: "
						+ e.getFechaUltimaModificacion() + ", estado: " + e.getEstado() + ", fechaArchivado: "
						+ e.getFechaArchivado() + ", documentos: " + e.getDocumentos());
			}
			pw.println("******************************");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		logger.info("Saliendo del metodo IntroducirExpedientesEnFichero");
	}

}
