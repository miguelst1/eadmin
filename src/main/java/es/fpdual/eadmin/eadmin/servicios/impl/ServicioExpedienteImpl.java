package es.fpdual.eadmin.eadmin.servicios.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioExpedienteImpl;
import es.fpdual.eadmin.eadmin.servicios.ServicioExpediente;

@Service
public class ServicioExpedienteImpl implements ServicioExpediente {

	private final RepositorioExpedienteImpl repositorioExpediente;

	@Autowired
	public ServicioExpedienteImpl(RepositorioExpedienteImpl repositorioExpediente) {
		this.repositorioExpediente = repositorioExpediente;
	}

	@Override
	public Expediente altaExpediente(Expediente expediente) {
		final Expediente expedienteAlta = obtenerExpedienteConFechaAltaCorrecta(expediente);

		repositorioExpediente.altaExpediente(expedienteAlta);
		return expedienteAlta;
	}

	@Override
	public Expediente modificarExpediente(Expediente expediente) {
		final Expediente expedienteModificar = obtenerExpedienteConFechaModificarCorrecta(expediente);

		repositorioExpediente.modificarExpediente(expedienteModificar);
		return expedienteModificar;
	}

	@Override
	public void eliminarExpediente(Integer codigoExpediente) {
		repositorioExpediente.eliminarExpediente(codigoExpediente);
	}

	@Override
	public Expediente asociarDocumentoAlExpediente(Integer codigoExpediente, Documento documento) {
		Optional<Expediente> expedienteEncontrado = repositorioExpediente.getExpedientes().stream()
				.filter(d -> d.getCodigo().equals(codigoExpediente)).findFirst();

		if (expedienteEncontrado.isPresent()) {
			if (!expedienteEncontrado.get().getDocumentos().contains(documento)) {
				expedienteEncontrado.get().getDocumentos().add(documento);
			}
			return expedienteEncontrado.get();
		}
		return null;
	}

	@Override
	public Expediente desasociarDocumentoDelExpediente(Integer codigoExpediente, Integer codigoDocumento) {
		Optional<Expediente> expedienteEncontrado = repositorioExpediente.getExpedientes().stream()
				.filter(d -> d.getCodigo().equals(codigoExpediente)).findFirst();
		Optional<Documento> documentoEncontrado = expedienteEncontrado.get().getDocumentos().stream()
				.filter(d -> d.getCodigo().equals(codigoDocumento)).findFirst();

		if (expedienteEncontrado.isPresent() && documentoEncontrado.isPresent()) {
			if (expedienteEncontrado.get().getDocumentos().contains(documentoEncontrado.get())) {
				expedienteEncontrado.get().getDocumentos().remove((int) codigoDocumento);
			}
			return expedienteEncontrado.get();
		}
		return null;
	}

	@Override
	public Expediente obtenerExpedientePorCodigo(Integer codigo) {
		return repositorioExpediente.obtenerExpedientePorCodigo(codigo);
	}

	@Override
	public List<Expediente> obtenerTodosLosExpedientes() {
		return repositorioExpediente.obtenerTodosLosExpedientes();
	}

	protected Date dameFechaActual() {
		return new Date();
	}

	public Expediente obtenerExpedienteConFechaAltaCorrecta(Expediente expediente) {
		return new Expediente(expediente.getCodigo(), expediente.getNombre(), dameFechaActual(),
				expediente.getFechaArchivado(), expediente.getPublico(), expediente.getEstado(), dameFechaActual(),
				expediente.getDocumentos());
	}

	public Expediente obtenerExpedienteConFechaModificarCorrecta(Expediente expediente) {
		return new Expediente(expediente.getCodigo(), expediente.getNombre(), dameFechaActual(),
				expediente.getFechaArchivado(), expediente.getPublico(), expediente.getEstado(),
				expediente.getFechaUltimaModificacion(), expediente.getDocumentos());
	}

}
