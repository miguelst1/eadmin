package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

@Repository
public class RepositorioExpedienteImpl implements RepositorioExpediente {
	
	private final List<Expediente> expedientes = new ArrayList<>();
	
	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	@Override
	public void altaExpediente(Expediente expediente) {
		if (expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente ya existe");
		}
		expedientes.add(expediente);
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if (!expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		expedientes.set(expedientes.indexOf(expediente), expediente);
	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		Optional<Expediente> expedienteEncontrado = expedientes.stream().filter(d -> d.getCodigo().equals(codigo)).findFirst();
		
		if (expedienteEncontrado.isPresent()) {
			expedientes.remove(expedienteEncontrado.get());
		}
	}

	@Override
	public Expediente obtenerExpedientePorCodigo(Integer codigo) {
		Optional<Expediente> expedienteEncontrado = expedientes.stream().filter(d -> d.getCodigo().equals(codigo)).findFirst();
		
		if (expedienteEncontrado.isPresent()) {
			return expedienteEncontrado.get();
		}
		
		return null;
	}

	@Override
	public List<Expediente> obtenerTodosLosExpedientes() {
		return getExpedientes();
	}

}
