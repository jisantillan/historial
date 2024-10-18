package org.domingus.logger;

import org.domingus.interfaces.Observer;

public class MessageListener implements Observer {
	
	private LogAdapter adapter;

	public MessageListener(LogAdapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public void update(Object object) {
		adapter.adapt((String) object);
	}

}