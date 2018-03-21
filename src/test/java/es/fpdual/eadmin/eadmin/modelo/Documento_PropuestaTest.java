package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.junit.Test;

public class Documento_PropuestaTest {

	private static final Date FECHA = new Date();
	private static Documento_Propuesta documentoPropuesta = new Documento_Propuesta(1, "Factura1", FECHA, false, EstadoDocumento.ELIMINADO, 1, 2010, "PSOE");
	
	@Test
	public void deberiaComprobarGetters()  {
		
	}
}
