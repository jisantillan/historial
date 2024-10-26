package org.domingus.init;

import org.domingus.logger.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerFactory {
	
	public Logger create(String path) throws IOException {
		PrintWriter writer = new PrintWriter(new FileWriter(path, true), true);
		return new Logger(writer);
	}

}