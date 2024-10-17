package org.domingus.logger;

import java.util.List;

public class Logger {
	
	private Reader reader;
	private Writer writer;
	
	public Logger(String path) {
		reader = new Reader(path);
		writer = new Writer(path);
	}
	
	public void writeLog(Log log) {
		List<Log> logs = reader.readAll();
		logs.add(log);
		System.out.println("Se añadio el log: " + log.getDate() + " " + log.getMessage());
		writer.write(logs);
	}

}