package es.fpdual.eadmin.eadmin.repositorio;

import java.util.Date;
import static org.junit.Assert.*;

import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;

public class RepositorioDocumentoImplTest {
	
	private static final Date FECHA = new Date();
	private static RepositorioDocumentoImpl repositorioDocumento = new RepositorioDocumentoImpl();
	private static Documento documento1 = new Documento(1, "Factura", FECHA, true, EstadoDocumento.APROBADO);
	private static Documento documento2 = new Documento(2, "Factura", FECHA, true, EstadoDocumento.APROBADO);
	
	@Test
	public void deberiaDevolverTrueSiSeInsertaElDocumento() {
		repositorioDocumento.altaDocumento(documento1);
		assertEquals(true, repositorioDocumento.getDocumentos().size() == 1);
		assertEquals(true, repositorioDocumento.getDocumentos().get(0).getCodigo() == 1);
	}
	
	@Test
	public void deberiaDevolverTrueSiSeEliminaElDocumento() {
		repositorioDocumento.getDocumentos().add(documento2);
		repositorioDocumento.eliminarDocumento(documento2.getCodigo());
		assertEquals(true, repositorioDocumento.getDocumentos().size() == 1);
	}
	
	@Test
	public void deberiaDevolverTrueSiSeModificaElDocumento() {
		repositorioDocumento.modificarDocumento(documento1);
		assertEquals(0, repositorioDocumento.getDocumentos().indexOf(documento1));
	}
}
