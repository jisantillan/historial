package org.domingus.logger;

import org.domingus.interfaces.Observer;

public class LogNotifier implements Observer {
	
	private LogAdapter adapter;

	public LogNotifier(LogAdapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public void update(Object object) {
		adapter.adapt((String) object);
	}

}