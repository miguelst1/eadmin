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

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicios.impl.ServicioDocumentoImpl;

public class ServicioDocumentoImplTest {

	private ServicioDocumentoImpl servicioDocumento;
	private RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
	private Documento documento1 = mock(Documento.class);

	@Before
	public void inicializarVariables() {
		this.servicioDocumento = spy(new ServicioDocumentoImpl(repositorioDocumento));
	}

	@Test
	public void deberiaAlmacenarUnDocumento() {
		final Documento documentoModificado = mock(Documento.class);
		doReturn(documentoModificado).when(servicioDocumento).obtenerDocumentoConFechaCorrectaAlta(documento1);

		final Documento resultado = this.servicioDocumento.altaDocumento(documento1);

		verify(this.repositorioDocumento).altaDocumento(documentoModificado);
		assertSame(documentoModificado, resultado);
	}

	@Test
	public void deberiaModificarUnDocumento() {
		final Documento documentoModificado = mock(Documento.class);
		doReturn(documentoModificado).when(servicioDocumento).obtenerDocumentoConFechaCorrectaModificar(documento1);

		final Documento resultado = this.servicioDocumento.modificarDocumento(documento1);

		verify(this.repositorioDocumento).modificarDocumento(documentoModificado);
		assertSame(resultado, documentoModificado);
	}

	@Test
	public void deberiaEliminarUnDocumento() {
		when(documento1.getCodigo()).thenReturn(1);

		this.servicioDocumento.eliminarDocumento(documento1.getCodigo());

		verify(this.repositorioDocumento).eliminarDocumento(1);
	}

	@Test
	public void deberiaObtenerDocumentoPorCodigo() {
		when(repositorioDocumento.obtenerDocumentoPorCodigo(1)).thenReturn(documento1);

		final Documento resultado = this.servicioDocumento.obtenerDocumentoPorCodigo(1);

		assertSame(resultado, documento1);
	}

	@Test
	public void deberiaObtenerTodosLosDocumentos() {
		List<Documento> lista = new ArrayList<>();
		when(repositorioDocumento.obtenerTodosLosDocumentos()).thenReturn(lista);

		final List<Documento> resultado = this.servicioDocumento.obtenerTodosLosDocumentos();

		assertSame(resultado, lista);
	}
}
