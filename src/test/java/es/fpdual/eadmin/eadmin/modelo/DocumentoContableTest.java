package es.fpdual.eadmin.eadmin.modelo;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.*;
import static org.junit.Assert.*;

public class DocumentoContableTest {
	
	private static final Date FECHA = new Date();
	private static BigDecimal numero = new BigDecimal(1000);
	private static DocumentoContable documentoContable = new DocumentoContable(1, "Factura", FECHA, true, EstadoDocumento.APROBADO,  new Date(1/1/2010), numero, "12345678A");
	
	@Test
	public void deberiaComprobarGetters() {
		assertEquals(numero, documentoContable.getImporte());
		assertEquals("12345678A", documentoContable.getDni_Interesado());
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenElMismoToString() {
		DocumentoContable documentoContable2 = new DocumentoContable(1, "Factura1", FECHA, false, EstadoDocumento.ELIMINADO, new Date(1/1/2010), numero, "12345678B");
		assertEquals(true, documentoContable.toString().equals(documentoContable2.toString()));
	}
}
