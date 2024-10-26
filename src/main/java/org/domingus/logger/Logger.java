package org.domingus.logger;

import org.domingus.interfaces.Observer;

import java.io.PrintWriter;
import java.util.Date;

public class Logger implements Observer {

	private PrintWriter writer;
	
	public Logger(PrintWriter writer) {
		this.writer = writer;
	}
	
	public void log(String message) {
		String entry = new Date().toString() + " " + message;
		writer.println(entry);
	}

	@Override
	public void update(Object object) {
		log((String) object);
	}


}