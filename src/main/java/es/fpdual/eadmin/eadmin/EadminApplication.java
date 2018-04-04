package es.fpdual.eadmin.eadmin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EadminApplication {

	private static final Logger logger = LoggerFactory.getLogger(EadminApplication.class);

	public static void main(String[] args) {
		logger.info("Esto es una prueba");

		logger.debug("Depuración");

		logger.info("Información");

		logger.trace("Traza");

		logger.warn("Advertencia");

		logger.error("Error");

		logger.info("Inicio Run");

		SpringApplication.run(EadminApplication.class, args);

		logger.info("Fin Run");
	}
}
