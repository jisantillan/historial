package org.domingus.init;

import org.domingus.logger.LogAdapter;
import org.domingus.logger.Logger;
import org.domingus.logger.LogNotifier;

public class LogNotifierFactory {
	
	public LogNotifier create(String path) {
		Logger logger = new Logger(path);
		LogAdapter logAdapter = new LogAdapter(logger);
		return new LogNotifier(logAdapter);
	}

}