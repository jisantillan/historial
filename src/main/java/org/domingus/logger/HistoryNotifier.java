package org.domingus.logger;

import org.domingus.interfaces.Notifier;

public class HistoryNotifier implements Notifier {
	
	private static String NAME = "HistoryNotifier";
	private NotificationAdapter adapter;

	public HistoryNotifier(NotificationAdapter adapter) {
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