package org.domingus.logger;

import org.domingus.interfaces.Notifier;

public class LogNotifier implements Notifier {
	
	private static String NAME = "LogNotifier";
	private LogAdapter adapter;

	public LogNotifier(LogAdapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public void notify(String message) {
		adapter.adapt(message);
	}

	@Override
	public String getName() {
		return NAME;
	}

}