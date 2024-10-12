package org.domingus.logger;

import java.util.Date;
import java.util.List;

import org.domingus.interfaces.Notifier;

public class Logger implements Notifier {
	
	private static String NAME = "Logger";
	
	private DataReader reader;
	private DataWritter writter;
	
	public Logger(String path) {
		reader = new DataReader(path);
		writter = new DataWritter(path);
	}
	
	public List<Notification> readHistory() {
		return reader.read();
	}

	@Override
	public void notify(String message) {
		System.out.println("A notification has been received!");
		List<Notification> notificaciones = reader.read();
		notificaciones.add(new Notification(message, new Date()));
		writter.write(notificaciones);
	}

	@Override
	public String getName() {
		return NAME;
	}

}