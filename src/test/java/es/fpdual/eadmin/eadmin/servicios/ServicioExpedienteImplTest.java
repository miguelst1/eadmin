package es.fpdual.eadmin.eadmin.servicios;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioExpedienteImpl;
import es.fpdual.eadmin.eadmin.servicios.impl.ServicioExpedienteImpl;

public class ServicioExpedienteImplTest {

	private ServicioExpedienteImpl servicioExpediente;
	private RepositorioExpedienteImpl repositorioExpediente = mock(RepositorioExpedienteImpl.class);
	private Expediente expediente1 = mock(Expediente.class);

	@Before
	public void inicializarVariables() {
		servicioExpediente = spy(new ServicioExpedienteImpl(repositorioExpediente));
	}

	@Test
	public void testServicioExpedienteImpl() {

	}

	@Test
	public void testAltaExpediente() {
		final Expediente expedienteModificado = mock(Expediente.class);
		doReturn(expedienteModificado).when(servicioExpediente).obtenerExpedienteConFechaAltaCorrecta(expediente1);

		final Expediente resultado = this.servicioExpediente.altaExpediente(expediente1);

		verify(repositorioExpediente).altaExpediente(expedienteModificado);
		assertSame(resultado, expedienteModificado);
	}

	@Test
	public void testModificarExpediente() {
		final Expediente expedienteModificado = mock(Expediente.class);
		doReturn(expedienteModificado).when(servicioExpediente).obtenerExpedienteConFechaModificarCorrecta(expediente1);

		final Expediente resultado = this.servicioExpediente.modificarExpediente(expediente1);

		verify(repositorioExpediente).modificarExpediente(expedienteModificado);
		assertSame(resultado, expedienteModificado);
	}

	@Test
	public void testEliminarExpediente() {
		when(expediente1.getCodigo()).thenReturn(1);

		this.servicioExpediente.eliminarExpediente(expediente1.getCodigo());

		verify(this.repositorioExpediente).eliminarExpediente(1);
	}

	@Test
	public void testAsociarDocumentoAlExpediente() {

	}

	@Test
	public void testDesasociarDocumentoDelExpediente() {

	}

	@Test
	public void testObtenerExpedientePorCodigo() {
		when(repositorioExpediente.obtenerExpedientePorCodigo(1)).thenReturn(expediente1);

		final Expediente resultado = this.repositorioExpediente.obtenerExpedientePorCodigo(1);

		assertSame(resultado, expediente1);
	}

	@Test
	public void testObtenerTodosLosExpedientes() {
		final List<Expediente> lista = new ArrayList<>();
		when(repositorioExpediente.obtenerTodosLosExpedientes()).thenReturn(lista);

		final List<Expediente> resultado = this.repositorioExpediente.obtenerTodosLosExpedientes();

		assertSame(resultado, lista);
	}
}
