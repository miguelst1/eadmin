package es.fpdual.eadmin.eadmin.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;

public class RepositorioDocumentoImplTest {
	
	private static final Date FECHA = new Date();
	private static RepositorioDocumentoImpl repositorio = new RepositorioDocumentoImpl();
	private static Documento documento1 = new Documento(1, "Factura", FECHA, true, EstadoDocumento.APROBADO);
	private static Documento documento2 = new Documento(2, "Factura", FECHA, true, EstadoDocumento.APROBADO);
	private static Documento documento3 = new Documento(3, "Factura", FECHA, true, EstadoDocumento.APROBADO);
	private static List<Documento> lista = new ArrayList<>();
	
	@Before
	public void listaDeDocumentos() {
		lista.add(documento1);
		lista.add(documento2);
	}
	
	@Test
	public void deberiaDevolverTrueSiSeInsertaElDocumento() {
		repositorio.getDocumentos().add(documento1);
		assertEquals(true, repositorio.getDocumentos().size() == 1);
		assertEquals(true, repositorio.getDocumentos().get(0).getCodigo() == 1);
	}
}
