package org.domingus.logger;

import java.util.Date;

public class Log {
	
	private String message;
	private String date;
	
	public Log(String message) {
		this.message = message;
		this.date = new Date().toString();
	}

	public Log() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}