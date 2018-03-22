package es.fpdual.eadmin.eadmin.repositorio;

import java.util.Date;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;

public class RepositorioDocumentoImplTest {
	
	private static final Date FECHA = new Date();
	private static RepositorioDocumentoImpl repositorioDocumento;
	private static Documento documento1;
	private static Documento documento2;
	
	@Before
	public void inicializarVariables() {
		repositorioDocumento = new RepositorioDocumentoImpl();
		documento1 = new Documento(1, "Factura", FECHA, true, EstadoDocumento.APROBADO, new Date(1/1/2010));
		documento2 = new Documento(2, "Factura", FECHA, true, EstadoDocumento.APROBADO, new Date(1/1/2010));
	}
	
	@Test
	public void deberiaDevolverTrueSiSeInsertaElDocumento() {
		repositorioDocumento.altaDocumento(documento1);
		assertEquals(true, repositorioDocumento.getDocumentos().size() == 1);
		assertEquals(true, repositorioDocumento.getDocumentos().get(0).getCodigo() == 1);
	}
	
	@Test
	public void deberiaDevolverTrueSiSeEliminarElDocumento() {
		repositorioDocumento.getDocumentos().add(documento2);
		repositorioDocumento.eliminarDocumento(documento2.getCodigo());
		assertEquals(true, repositorioDocumento.getDocumentos().size() == 0);
	}
	
	@Test
	public void deberiaDevolverTrueSiSeModificaElDocumento() {
		repositorioDocumento.getDocumentos().add(documento1);
		repositorioDocumento.modificarDocumento(documento1);
		assertEquals(0, repositorioDocumento.getDocumentos().indexOf(documento1));
	}
	
	@Test(expected = NullPointerException.class)
	public void deberiaDevolverFalseSiSeIntentaEliminarElDocumentoQueNoExiste() {
		repositorioDocumento.eliminarDocumento(documento2.getCodigo());
		assertEquals(true, repositorioDocumento.getDocumentos().isEmpty());
	}
}
