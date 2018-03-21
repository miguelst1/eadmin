package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class ExpedienteTest {
	
	private static Date fechaCreacion = new Date();
	private static Date fechaArchivado = new Date();
	private static ArrayList<Documento> lista = new ArrayList<>();
	private static Expediente expediente1 = new Expediente(1, "MST", fechaCreacion, fechaArchivado, false, EstadoExpediente.EN_TRAMITE, lista);
	
	@Test
	public void deberiaComprobarGetters() {
		assertEquals(Integer.valueOf(1), expediente1.getCodigo());
		assertEquals("MST", expediente1.getNombre());
		assertEquals(fechaCreacion, expediente1.getFechaCreacion());
		assertEquals(fechaArchivado, expediente1.getFechaArchivado());
		assertEquals(false, expediente1.getPublico());
		assertEquals(EstadoExpediente.EN_TRAMITE, expediente1.getEstado());
		assertEquals(lista, expediente1.getDocumentos());
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenLosMismoAtributos() {
		Expediente expediente2 = new Expediente(1, "MST", fechaCreacion, fechaArchivado, false, EstadoExpediente.EN_TRAMITE, lista);
		assertEquals(true, expediente1.equals(expediente2));
	}
}
