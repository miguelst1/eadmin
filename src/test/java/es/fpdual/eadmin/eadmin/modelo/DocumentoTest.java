package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class DocumentoTest {
	
	private static final Date FECHA = new Date();
	
	@Test
	public void deberiaComprobarGetters() {
		Documento documento1 = new Documento(1, "Factura", FECHA, true, EstadoDocumento.APROBADO);
		assertEquals(Integer.valueOf(1), documento1.getCodigo());
		assertEquals("Factura", documento1.getNombre());
		assertEquals(FECHA, documento1.getFechaCreacion());
		assertEquals(true, documento1.getPublico());
		assertEquals(EstadoDocumento.APROBADO, documento1.getEstado());
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		Documento documento1 = new Documento(1, "Factura", FECHA, true, EstadoDocumento.APROBADO);
		Documento documento2 = new Documento(1, "Factura", FECHA, true, EstadoDocumento.APROBADO);
		assertEquals(true, documento1.equals(documento2));
	}
	
	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		Documento documento1 = new Documento(1, "Factura", FECHA, true, EstadoDocumento.APROBADO);
		Documento documento2 = new Documento(2, "Factura", FECHA, true, EstadoDocumento.APROBADO);
		assertEquals(false, documento1.equals(documento2));
	}
	
	@Test
	public void deberiaDevolverFalseSiNoSonObjetosDelMismoTipo() {
		Documento documento1 = new Documento(1, "Factura", FECHA, true, EstadoDocumento.APROBADO);
		assertEquals(false, documento1.equals(new String()));
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenIgualHashCode() {
		Documento documento1 = new Documento(1, "Factura", FECHA, true, EstadoDocumento.APROBADO);
		assertEquals(documento1.getCodigo().hashCode() , documento1.hashCode());
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenElMismoToString() {
		Documento documento1 = new Documento(1, "Factura", FECHA, true, EstadoDocumento.APROBADO);
		assertEquals("Documento 1", documento1.toString());
	}
}
