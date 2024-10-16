package org.domingus.logger;

public class LogAdapter {
	
	private Logger logger;

	public LogAdapter(Logger logger) {
		this.logger = logger;
	}
	
	public void adapt(String message) {
		logger.writeLog(new Log(message));
	}
	
}