package org.domingus.logger;

import java.util.List;

public class Logger {
	
	private Reader reader;
	private Writer writer;
	
	public Logger(String path) {
		reader = new Reader(path);
		writer = new Writer(path);
	}
	
	public void log(Notification notification) {
		List<Notification> notificaciones = reader.readAll();
		notificaciones.add(notification);
		writer.write(notificaciones);
	}

}