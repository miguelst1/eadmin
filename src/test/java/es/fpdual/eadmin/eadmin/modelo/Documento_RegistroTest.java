package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.*;

public class Documento_RegistroTest {
	
	private static final Date FECHA = new Date();
	private static Documento_Registro documentoRegistro = new Documento_Registro(1, "Factura", FECHA, true, EstadoDocumento.APROBADO,
			"11111111A", "1");
	
	@Test
	public void deberiaComprobarGetters() {
		assertEquals("11111111A", documentoRegistro.getDniInteresado());
		assertEquals("1", documentoRegistro.getCodigoRegistro());
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenElMismoToString() {
		Documento_Registro documentoRegistro2 = new Documento_Registro(1, "Factura1", FECHA, false, EstadoDocumento.ELIMINADO, "12345678B", "1");
		assertEquals(true, documentoRegistro.toString().equals(documentoRegistro2.toString()));
	}
}
