package org.domingus.logger;

public class HistoryNotifierFactory {
	
	public HistoryNotifier create(String path) {
		Logger logger = new Logger(path);
		NotificationAdapter notificationAdapter = new NotificationAdapter(logger);
		return new HistoryNotifier(notificationAdapter);
	}

}