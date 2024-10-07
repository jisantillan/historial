package org.domingus.logger;

import java.util.Date;
import java.util.List;

import org.domingus.interfaces.NotificationPlatform;

public class Logger implements NotificationPlatform {
		
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
	public void sendMessage(String message) {
		System.out.println("A notification has been received!");
		List<Notification> notificaciones = reader.read();
		notificaciones.add(new Notification(message, new Date()));
		writter.write(notificaciones);
	}

}