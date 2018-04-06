package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private static final Logger logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);

	private final List<Documento> documentos = new ArrayList<>();
	private static int contador = 2;

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public void altaDocumento(Documento documento) {
		logger.info("Entrando al metodo altaDocumento");
		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}
		documentos.add(documento);

		altaDocumentoTxt(documento);

		exportExcel("Alta", documento, "ExcelDocumentos.xlsx");

		logger.info("El documento con código " + documento.getCodigo() + " se ha creado correctamente");
		logger.info("Saliendo del metodo altaDocumento");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		logger.info("Entrando al metodo modificarDocumento");
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		documentos.set(documentos.indexOf(documento), documento);

		modificarDocumentoTxt(documento);

		exportExcel("Modificar", documento, "ExcelDocumentos.xlsx");

		logger.info("Saliendo del metodo modificarDocumento");
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		logger.info("Entrando al metodo eliminarDocumento");
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			documentos.remove(documentoEncontrado.get());

			eliminarDocumentoTxt(documentoEncontrado.get());

			exportExcel("Eliminar", documentoEncontrado.get(), "ExcelDocumentos.xlsx");

			logger.info("El documento con codigo " + codigo + " se ha eliminado correctamente");
			logger.info("Saliendo del metodo eliminarDocumento. Documento eliminado");
		} else {
			logger.info("Saliendo del metodo eliminarDocumento. Documento no eliminado");
		}
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		logger.info("Entrando al metodo obtenerDocumentoPorCodigo");
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			logger.info("Saliendo del metodo obtenerDocumentoPorCodigo. Documento encontrado");
			return documentoEncontrado.get();
		}
		logger.info("Saliendo del metodo obtenerDocumentoPorCodigo. Documento no encontrado");
		return null;
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		logger.info("Entrando al metodo obtenerTodosLosDocumentos");
		for (Documento d : getDocumentos()) {
			logger.info("codigo: " + d.getCodigo() + ", nombre: " + d.getNombre() + ", fechaCreacion: "
					+ d.getFechaCreacion() + ", publico: " + d.getPublico() + ", fechaUltimaModificacion: "
					+ d.getFechaUltimaModificacion() + ", estado: " + d.getEstado());
			exportExcel("Todos los documentos", d, "ExcelDocumentos.xlsx");
		}

		logger.info("Saliendo del metodo obtenerTodosLosDocumentos");
		return getDocumentos();
	}

	public void IntroducirDocumentosEnFichero(List<Documento> lista) {
		logger.info("Entrando al metodo IntroducirDocumentosEnFichero");

		String nombreFichero = "documentos.txt";
		File fichero = new File(nombreFichero);
		FileWriter file = null;
		PrintWriter pw = null;

		try {
			if (fichero.exists()) {
				logger.info("Modificando fichero");
			} else {
				logger.info("Creando fichero");
			}
			file = new FileWriter(nombreFichero, true);
			pw = new PrintWriter(file);

			for (Documento d : lista) {
				pw.println("codigo: " + d.getCodigo() + ", nombre: " + d.getNombre() + ", fechaCreacion: "
						+ d.getFechaCreacion() + ", publico: " + d.getPublico() + ", fechaUltimaModificacion: "
						+ d.getFechaUltimaModificacion() + ", estado: " + d.getEstado());
			}
			pw.println("******************************");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		logger.info("Saliendo del metodo IntroducirDocumentosEnFichero");
	}

	public void altaDocumentoTxt(Documento documento) {
		logger.info("Entrando al metodo altaDocumentoTxt");

		String nombreFichero = "alta.txt";
		File fichero = new File(nombreFichero);
		FileWriter file = null;
		PrintWriter pw = null;

		try {
			if (fichero.exists()) {
				logger.info("Modificando fichero");
			} else {
				logger.info("Creando fichero");
			}
			file = new FileWriter(nombreFichero, true);
			pw = new PrintWriter(file);

			pw.println("codigo: " + documento.getCodigo() + ", nombre: " + documento.getNombre() + ", fechaCreacion: "
					+ documento.getFechaCreacion() + ", publico: " + documento.getPublico()
					+ ", fechaUltimaModificacion: " + documento.getFechaUltimaModificacion() + ", estado: "
					+ documento.getEstado());
			pw.println("***********************************");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		logger.info("Saliendo del metodo altaDocumentoTxt");
	}

	public void modificarDocumentoTxt(Documento documento) {
		logger.info("Entrando al metodo modificarDocumentoTxt");

		String nombreFichero = "modificar.txt";
		File fichero = new File(nombreFichero);
		FileWriter file = null;
		PrintWriter pw = null;

		try {
			if (fichero.exists()) {
				logger.info("Modificando fichero");
			} else {
				logger.info("Creando fichero");
			}
			file = new FileWriter(nombreFichero, true);
			pw = new PrintWriter(file);

			pw.println("codigo: " + documento.getCodigo() + ", nombre: " + documento.getNombre() + ", fechaCreacion: "
					+ documento.getFechaCreacion() + ", publico: " + documento.getPublico()
					+ ", fechaUltimaModificacion: " + documento.getFechaUltimaModificacion() + ", estado: "
					+ documento.getEstado());
			pw.println("***********************************");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		logger.info("Saliendo del metodo modificarDocumentoTxt");
	}

	public void eliminarDocumentoTxt(Documento documento) {
		logger.info("Entrando al metodo eliminarDocumentoTxt");

		String nombreFichero = "eliminar.txt";
		File fichero = new File(nombreFichero);
		FileWriter file = null;
		PrintWriter pw = null;

		try {
			if (fichero.exists()) {
				logger.info("Modificando fichero");
			} else {
				logger.info("Creando fichero");
			}
			file = new FileWriter(nombreFichero, true);
			pw = new PrintWriter(file);

			pw.println("codigo: " + documento.getCodigo() + ", nombre: " + documento.getNombre() + ", fechaCreacion: "
					+ documento.getFechaCreacion() + ", publico: " + documento.getPublico()
					+ ", fechaUltimaModificacion: " + documento.getFechaUltimaModificacion() + ", estado: "
					+ documento.getEstado());
			pw.println("***********************************");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}

		logger.info("Saliendo del metodo eliminarDocumentoTxt");
	}

	// public static void exportarExcel(Object object, String nombreHoja, int
	// numero) {
	// String[] lista = { "alta.xlsx", "modificar.xlsx", "eliminar.xlsx",
	// "documentos.xlsx" };
	// int elementosLista = 0;
	//
	// Map<String, Object[]> data = new TreeMap<>();
	//
	// if (object instanceof Documento) {
	// Documento documento = (Documento) object;
	//
	// data.put("1", new Object[] { "Codigo", "Nombre", "Fecha Creacion", "Publico",
	// "Fecha Ultima Modificacion",
	// "Estado" });
	// data.put(String.valueOf(contador),
	// new Object[] { documento.getCodigo(), documento.getNombre(),
	// documento.getFechaCreacion(),
	// documento.getPublico(), documento.getFechaUltimaModificacion(),
	// documento.getEstado() });
	// } else if (object instanceof List<?>) {
	// List<Documento> listaDocumentos = (List<Documento>) object;
	//
	// Object[] objectListaDocumentos = new Object[listaDocumentos.size()];
	// for (Documento documento2 : listaDocumentos) {
	// objectListaDocumentos[elementosLista] = documento2;
	// elementosLista++;
	// }
	//
	// data.put(String.valueOf(contador), objectListaDocumentos);
	//
	// contador++;
	//
	// // Creamos el libro de trabajo
	// XSSFWorkbook libro = new XSSFWorkbook();
	//
	// // Creacion de Hoja
	// XSSFSheet hoja = libro.createSheet(nombreHoja);
	//
	// // Iteramos el map e insertamos los datos
	// Set<String> keyset = data.keySet();
	// int rownum = 0;
	// for (String key : keyset) {
	// // creamos la fila
	// Row row = hoja.createRow(rownum++);
	// // obtenemos los datos de la fila
	// Object[] objArr = data.get(key);
	// int cellnum = 0;
	// // iteramos cada dato de la fila
	// for (Object obj : objArr) {
	// // Creamos la celda
	// Cell cell = row.createCell(cellnum++);
	// // Setteamos el valor con el tipo de dato correspondiente
	// if (obj instanceof String)
	// cell.setCellValue((String) obj);
	// else if (obj instanceof Integer)
	// cell.setCellValue((Integer) obj);
	// }
	// }
	// try {
	// // Escribimos en fichero
	// FileOutputStream out = new FileOutputStream(new File(lista[numero]));
	// libro.write(out);
	// // cerramos el fichero y el libro
	// out.close();
	// libro.close();
	// System.out.println("Excel exportado correctamente\n");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	// }

	public static boolean exportExcel(String nombreHoja, Documento documento, String fileName) {

		Map<String, Object[]> documentos = new TreeMap<String, Object[]>();
		Integer numeroLineas = 0;

		File archivoExcel = new File(fileName);
		if (!archivoExcel.exists()) {
			// Cabecera
			documentos.put("0", new Object[] { "ID", "NOMBRE", "FECHA", "PUBLICO" });
			numeroLineas++;
		} else {
			ArrayList<String[]> datosExcel = importExcel(fileName, 4);
			ListIterator<String[]> it = datosExcel.listIterator();

			while (it.hasNext()) {
				numeroLineas++;
				String[] datos = it.next();
				documentos.put(numeroLineas.toString(), datos);
			}
		}

		numeroLineas++;
		documentos.put(numeroLineas.toString(), new Object[] { documento.getCodigo(), documento.getNombre(),
				documento.getFechaCreacion().toString(), documento.getPublico().toString() });

		// Creamos el libro de trabajo
		XSSFWorkbook libro = new XSSFWorkbook();

		// Creacion de Hoja
		XSSFSheet hoja = libro.createSheet(nombreHoja);

		// Iteramos el map e insertamos los datos
		Set<String> keyset = documentos.keySet();
		int rownum = 0;
		for (String key : keyset) {
			// cramos la fila
			Row row = hoja.createRow(rownum++);
			// obtenemos los datos de la fila
			Object[] objArr = documentos.get(key);
			int cellnum = 0;
			// iteramos cada dato de la fila
			for (Object obj : objArr) {
				// Creamos la celda
				Cell cell = row.createCell(cellnum++);
				// Setteamos el valor con el tipo de dato correspondiente
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// Escribimos en fichero
			FileOutputStream out = new FileOutputStream(new File(fileName));
			libro.write(out);
			// cerramos el fichero y el libro
			out.close();
			libro.close();
			System.out.println("Excel exportado correctamente\n");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<String[]> importExcel(String fileName, int numColums) {

		// ArrayList donde guardaremos todos los datos del excel
		ArrayList<String[]> data = new ArrayList<>();

		try {
			// Acceso al fichero xlsx
			FileInputStream file = new FileInputStream(new File(fileName));

			// Creamos la referencia al libro del directorio dado
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Obtenemos la primera hoja
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterador de filas
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// Iterador de celdas
				Iterator<Cell> cellIterator = row.cellIterator();
				// contador para el array donde guardamos los datos de cada fila
				int contador = 0;
				// Array para guardar los datos de cada fila
				// y añadirlo al ArrayList
				String[] fila = new String[numColums];
				// iteramos las celdas de la fila
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// Guardamos los datos de la celda segun su tipo
					switch (cell.getCellType()) {
					// si es numerico
					case Cell.CELL_TYPE_NUMERIC:
						fila[contador] = (int) cell.getNumericCellValue() + "";
						break;
					// si es cadena de texto
					case Cell.CELL_TYPE_STRING:
						fila[contador] = cell.getStringCellValue() + "";
						break;
					}
					// Si hemos terminado con la ultima celda de la fila
					if ((contador + 1) % numColums == 0) {
						// Añadimos la fila al ArrayList con todos los datos
						data.add(fila);
					}
					// Incrementamos el contador
					// con cada fila terminada al redeclarar arriba el contador,
					// no obtenemos excepciones de ArrayIndexOfBounds
					contador++;
				}
			}
			// Cerramos el fichero y workbook
			file.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Excel importado correctamente\n");

		return data;
	}
}
