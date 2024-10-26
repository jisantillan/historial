package org.domingus.init;

import org.domingus.logger.Logger;
import org.domingus.logger.Writter;

import java.io.*;

public class LoggerFactory {
	
	public Logger create(String path) throws IOException {
		File file = new File(path);

		if (!file.exists()) {
			throw new IOException("El archivo en el path especificado no existe: " + path);
		}

		Writter writer = new Writter(path);
		return new Logger(writer);
	}

}