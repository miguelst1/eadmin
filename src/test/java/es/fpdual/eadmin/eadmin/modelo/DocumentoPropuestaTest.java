package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.*;

public class DocumentoPropuestaTest {

	private static final Date FECHA = new Date();
	private static DocumentoPropuesta documentoPropuesta = new DocumentoPropuesta(1, "Factura1", FECHA, false, EstadoDocumento.ELIMINADO, 1, 2010, "PSOE");
	
	@Test
	public void deberiaComprobarGetters()  {
		
	}
}
