package es.fpdual.eadmin.eadmin.repositorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioExpedienteImpl;

public class RepositorioExpedienteImplTest {

	private static Date fechaCreacion = new Date();
	private static Date fechaArchivado = new Date();
	private static ArrayList<Documento> lista = new ArrayList<>();
	private static Expediente expediente1;
	private static RepositorioExpedienteImpl repositorioExpediente;

	@Before
	public void inicializarVariables() {
		repositorioExpediente = new RepositorioExpedienteImpl();
		expediente1 = new Expediente(1, "MST", fechaCreacion, fechaArchivado, false, EstadoExpediente.EN_TRAMITE,
				new Date(1 / 1 / 2010), lista);
	}

	@Test
	public void deberiaDevolverTrueSiSeInsertaElExpediente() {
		repositorioExpediente.altaExpediente(expediente1);
		assertEquals(true, repositorioExpediente.getExpedientes().size() == 1);
	}

	@Test
	public void deberiaDevolverTrueSiSeModificaElExpediente() {
		repositorioExpediente.getExpedientes().add(expediente1);
		repositorioExpediente.modificarExpediente(expediente1);
		assertEquals(0, repositorioExpediente.getExpedientes().indexOf(expediente1));
	}

	@Test
	public void deberiaDevolverTrueSiSeEliminaElExpediente() {
		repositorioExpediente.getExpedientes().add(expediente1);
		repositorioExpediente.eliminarExpediente(expediente1.getCodigo());
		assertEquals(true, repositorioExpediente.getExpedientes().size() == 0);
	}

	@Test
	public void deberiaDevolverTrueSiSeDevuelveLaLista() {
		assertTrue(repositorioExpediente.obtenerTodosLosExpedientes().equals(repositorioExpediente.getExpedientes()));
	}

	@Test
	public void deberiaDevolverTrueSiExisteElDocumento() {
		repositorioExpediente.getExpedientes().add(expediente1);
		assertTrue(repositorioExpediente.obtenerExpedientePorCodigo(expediente1.getCodigo()).equals(expediente1));
	}

	@Test
	public void deberiaDevolverFalseSiNoExisteElDocumento() {
		assertFalse(repositorioExpediente.obtenerExpedientePorCodigo(expediente1.getCodigo()).equals(expediente1));
	}
}
