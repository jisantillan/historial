package org.domingus.logger;

import java.util.Date;

public class NotificationAdapter {
	
	private Logger logger;

	public NotificationAdapter(Logger logger) {
		this.logger = logger;
	}
	
	public void adapt(String message) {
		logger.log(new Notification(message, new Date()));
	}
	
}