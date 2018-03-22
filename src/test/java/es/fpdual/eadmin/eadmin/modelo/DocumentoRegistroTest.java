package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.*;

public class DocumentoRegistroTest {
	
	private static final Date FECHA = new Date();
	private static DocumentoRegistro documentoRegistro = new DocumentoRegistro(1, "Factura", FECHA, true, EstadoDocumento.APROBADO,
			 new Date(1/1/2010), "11111111A", "1");
	
	@Test
	public void deberiaComprobarGetters() {
		assertEquals("11111111A", documentoRegistro.getDniInteresado());
		assertEquals("1", documentoRegistro.getCodigoRegistro());
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenElMismoToString() {
		DocumentoRegistro documentoRegistro2 = new DocumentoRegistro(1, "Factura1", FECHA, false, EstadoDocumento.ELIMINADO, new Date(1/1/2010), "12345678B", "1");
		assertEquals(true, documentoRegistro.toString().equals(documentoRegistro2.toString()));
	}
}
