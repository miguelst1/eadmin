package es.fpdual.eadmin.eadmin.modelo;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.*;
import static org.junit.Assert.*;

public class Documento_ContableTest {
	
	private static final Date FECHA = new Date();
	private static BigDecimal numero = new BigDecimal(1000);
	private static Documento_Contable documentoContable = new Documento_Contable(1, "Factura", FECHA, true, EstadoDocumento.APROBADO, numero, "12345678A");
	
	@Test
	public void deberiaComprobarGetters() {
		assertEquals(numero, documentoContable.getImporte());
		assertEquals("12345678A", documentoContable.getDni_Interesado());
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenElMismoToString() {
		Documento_Contable documentoContable2 = new Documento_Contable(1, "Factura1", FECHA, false, EstadoDocumento.ELIMINADO, numero, "12345678B");
		assertEquals(true, documentoContable.toString().equals(documentoContable2.toString()));
	}
}
