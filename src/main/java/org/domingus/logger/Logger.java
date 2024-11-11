package org.domingus.logger;

import org.domingus.interfaces.Observer;

import java.util.Date;

public class Logger implements Observer {

	private Writer writer;
	
	public Logger(Writer writer) {
		this.writer = writer;
	}
	
	public void log(String message) {
		String entry = new Date().toString() + " " + message;
		writer.write(entry);
		System.out.println("Logged: " + entry);
	}

	@Override
	public void update(Object object) {
		log((String) object);
	}


}