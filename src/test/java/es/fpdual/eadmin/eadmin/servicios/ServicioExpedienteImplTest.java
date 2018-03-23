package es.fpdual.eadmin.eadmin.servicios;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioExpedienteImpl;
import es.fpdual.eadmin.eadmin.servicios.impl.ServicioExpedienteImpl;

public class ServicioExpedienteImplTest {

	private ServicioExpediente servicioExpediente;
	private RepositorioExpedienteImpl repositorioExpediente= mock(RepositorioExpedienteImpl.class);
	private Expediente expediente1 = mock(Expediente.class);
	
	@Before
	public void inicializarVariables() {
		servicioExpediente = new ServicioExpedienteImpl(repositorioExpediente);
	}
	
	@Test
	public void testServicioExpedienteImpl() {
		
	}

	@Test
	public void testAltaExpediente() {
		when(expediente1.getCodigo()).thenReturn(1);
		when(expediente1.getNombre()).thenReturn("Factura");
		when(expediente1.getFechaCreacion()).thenReturn(new Date(12/9/2010));
		when(expediente1.getFechaUltimaModificacion()).thenReturn(new Date(1/1/2010));
		
		final Expediente resultado = this.servicioExpediente.altaExpediente(expediente1);
		
		verify(this.repositorioExpediente).altaExpediente(any());
		assertEquals(resultado.getCodigo(), expediente1.getCodigo());
		assertEquals(resultado.getNombre(), expediente1.getNombre());
		assertNotEquals(resultado.getFechaCreacion(), expediente1.getFechaCreacion());
		assertNotEquals(resultado.getFechaUltimaModificacion(), expediente1.getFechaUltimaModificacion());
	}

	@Test
	public void testModificarExpediente() {
		when(expediente1.getCodigo()).thenReturn(1);
		when(expediente1.getNombre()).thenReturn("Factura");
		when(expediente1.getFechaCreacion()).thenReturn(new Date(12/9/2010));
		when(expediente1.getFechaUltimaModificacion()).thenReturn(new Date(1/1/2010));
		
		final Expediente resultado = this.servicioExpediente.modificarExpediente(expediente1);
		
		verify(this.repositorioExpediente).modificarExpediente(any());
		assertEquals(resultado.getCodigo(), expediente1.getCodigo());
		assertEquals(resultado.getNombre(), expediente1.getNombre());
		assertEquals(resultado.getFechaCreacion(), expediente1.getFechaCreacion());
		assertNotEquals(resultado.getFechaUltimaModificacion(), expediente1.getFechaUltimaModificacion());
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

}
