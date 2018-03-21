package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModeloAdministracionElectronicaTest {
	
	private static final Date FECHA = new Date();
	private static ModeloAdministracionElectronicaTestParaProbar modelo1 = new ModeloAdministracionElectronicaTestParaProbar(1, "MST", FECHA, true);
	
	@Test
	public void deberiaComprobarGetters() {
		assertEquals(Integer.valueOf(1), modelo1.getCodigo());
		assertEquals("MST", modelo1.getNombre());
		assertEquals(FECHA, modelo1.getFechaCreacion());
		assertEquals(true, modelo1.getPublico());
	}
	
	@Test
	public void deberiaDevolverTrueSiSonIguales() {
		ModeloAdministracionElectronicaTestParaProbar modelo2 = new ModeloAdministracionElectronicaTestParaProbar(1, "MST", FECHA, true);
		assertEquals(true, modelo1.equals(modelo2));
	}
}

class ModeloAdministracionElectronicaTestParaProbar extends ModeloAdministracionElectronica {

	public ModeloAdministracionElectronicaTestParaProbar(Integer codigo, String nombre, Date fechaCreacion,
			Boolean publico) {
		super(codigo, nombre, fechaCreacion, publico);
	}
}
