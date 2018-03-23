package es.fpdual.eadmin.eadmin.modelo.builder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdua.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public class DocumentoBuilderTest {

	DocumentoBuilder documentoBuilder;
	Documento documento = mock(Documento.class);
	
	@Before
	public void inicializarVariables() {
		documentoBuilder = new DocumentoBuilder();
	}
	@Test
	public void testConstruir() {
		documento = documentoBuilder.construir();
		
		assertEquals(null, documento.getCodigo());
	}

	@Test
	public void testConCodigo() {
		documentoBuilder.conCodigo(1);
		
		assertEquals(Integer.valueOf(1), documentoBuilder.construir().getCodigo());
	}

	@Test
	public void testConNombre() {
		documentoBuilder.conNombre("MST");
		
		assertEquals("MST", documentoBuilder.construir().getNombre());
	}

	@Test
	public void testConFechaCreacion() {
		documentoBuilder.conFechaCreacion(new Date(3/3/2010));
		
		assertEquals(new Date(3/3/2010), documentoBuilder.construir().getFechaCreacion());
	}

	@Test
	public void testConPublico() {
		documentoBuilder.conPublico(false);
		
		assertEquals(false, documentoBuilder.construir().getPublico());
	}

	@Test
	public void testConFechaUltimaModificacion() {
		documentoBuilder.conFechaUltimaModificacion(new Date(4/4/2010));
		
		assertEquals(new Date(4/4/2010), documentoBuilder.construir().getFechaUltimaModificacion());
	}

	@Test
	public void testConEstado() {
		documentoBuilder.conEstado(EstadoDocumento.ACTIVO);
		
		assertEquals(EstadoDocumento.ACTIVO, documentoBuilder.construir().getEstado());
	}

	@Test
	public void testClonar() {
		Documento documentoParaClonar = new Documento(1, "Factura", new Date(2/2/2002), true, EstadoDocumento.APROBADO, new Date(1/1/2010));
		Documento documentoClonado = documentoBuilder.clonar(documentoParaClonar).construir();
		
		assertEquals(Integer.valueOf(1), documentoClonado.getCodigo());
		assertEquals("Factura", documentoClonado.getNombre());
		assertEquals(new Date(2/2/2002), documentoClonado.getFechaCreacion());
		assertEquals(true, documentoClonado.getPublico());
		assertEquals(EstadoDocumento.APROBADO, documentoClonado.getEstado());
		assertEquals(new Date(1/1/2010), documentoClonado.getFechaUltimaModificacion());
	}

}
