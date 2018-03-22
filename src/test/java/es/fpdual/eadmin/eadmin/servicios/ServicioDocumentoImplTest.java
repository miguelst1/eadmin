package es.fpdual.eadmin.eadmin.servicios;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.Date;

import static org.junit.Assert.*;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicios.impl.ServicioDocumentoImpl;

public class ServicioDocumentoImplTest {
	
	private ServicioDocumento servicioDocumento;
	private RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
	private Documento documento1 = mock(Documento.class);
	
	@Before
	public void inicializarVariables() {
		this.servicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);
	}
	
	@Test
	public void deberiaAlmacenarUnDocumento() {
		when(documento1.getCodigo()).thenReturn(1);
		when(documento1.getNombre()).thenReturn("Factura");
		when(documento1.getFechaCreacion()).thenReturn(new Date(12/9/2010));
		when(documento1.getFechaUltimaModificacion()).thenReturn(new Date(1/1/2010));
		
		final Documento resultado = this.servicioDocumento.altaDocumento(documento1);
		
		verify(this.repositorioDocumento).altaDocumento(any());
		assertEquals(resultado.getCodigo(), documento1.getCodigo());
		assertEquals(resultado.getNombre(), documento1.getNombre());
		assertNotEquals(resultado.getFechaCreacion(), documento1.getFechaCreacion());
		assertNotEquals(resultado.getFechaUltimaModificacion(), documento1.getFechaUltimaModificacion());
	}
	
	@Test
	public void deberiaModificarUnDocumento() {
		when(documento1.getCodigo()).thenReturn(1);
		when(documento1.getNombre()).thenReturn("Factura");
		when(documento1.getFechaCreacion()).thenReturn(new Date(12/9/2010));
		when(documento1.getFechaUltimaModificacion()).thenReturn(new Date(1/1/2010));
		
		final Documento resultado = this.servicioDocumento.modificarDocumento(documento1);
		
		verify(this.repositorioDocumento).modificarDocumento(any());
		assertEquals(resultado.getCodigo(), documento1.getCodigo());
		assertEquals(resultado.getNombre(), documento1.getNombre());
		assertEquals(resultado.getFechaCreacion(), documento1.getFechaCreacion());
		assertNotEquals(resultado.getFechaUltimaModificacion(), documento1.getFechaUltimaModificacion());
	}
	
	@Test
	public void deberiaEliminarUnDocumento() {
		when(documento1.getCodigo()).thenReturn(1);
		
		this.servicioDocumento.eliminarDocumento(documento1.getCodigo());
		
		verify(this.repositorioDocumento).eliminarDocumento(1);
	}
}
