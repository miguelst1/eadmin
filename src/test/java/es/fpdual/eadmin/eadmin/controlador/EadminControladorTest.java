package es.fpdual.eadmin.eadmin.controlador;

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

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.servicios.ServicioDocumento;

public class EadminControladorTest {

	private EadminControlador eadminControlador;
	private ServicioDocumento servicioDocumento = mock(ServicioDocumento.class);
	private Documento documento1 = mock(Documento.class);

	@Before
	public void inicializarVariables() {
		this.eadminControlador = spy(new EadminControlador(servicioDocumento));
	}

	@Test
	public void testGetDocumento() {
		when(documento1.getCodigo()).thenReturn(1);
		doReturn(documento1).when(servicioDocumento).obtenerDocumentoPorCodigo(1);

		Documento documentoControlador = eadminControlador.getDocumento(1).getBody();

		assertSame(documento1, documentoControlador);
	}

	@Test
	public void testGetTodosDocumentos() {
		final List<Documento> lista = new ArrayList<>();
		doReturn(lista).when(servicioDocumento).obtenerTodosLosDocumentos();

		List<Documento> listaControlador = eadminControlador.getTodosDocumentos().getBody();

		assertSame(lista, listaControlador);
	}

	@Test
	public void testEliminarDocumento() {
		eadminControlador.eliminarDocumento(1);

		verify(servicioDocumento).eliminarDocumento(1);
	}
}
