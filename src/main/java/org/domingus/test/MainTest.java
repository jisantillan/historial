package org.domingus.test;

import java.io.FileNotFoundException;

import org.domingus.app.Domingus;
import org.domingus.init.DomingusFactory;
import org.domingus.interfaces.Source;
import org.domingus.logger.HistoryNotifier;
import org.domingus.logger.HistoryNotifierFactory;

public class MainTest {
	
	private static String EXTENSIONS_PATH = "src\\test\\resources\\extensions\\";
	private static String PATH_MEMORY = "src\\main\\resources\\memory\\memory.json";
	private static Integer TIME_INTERVAL = 1000;
	
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
    	System.out.println("Init App");
    	HistoryNotifierFactory historyNotifierFactory = new HistoryNotifierFactory();
    	HistoryNotifier historyNotifier = historyNotifierFactory.create(PATH_MEMORY);
        
    	DomingusFactory domingusFactory = new DomingusFactory();
    	Source source = new SourceLoggerMock(TIME_INTERVAL);
		Domingus domingus = domingusFactory.create(source, EXTENSIONS_PATH);
		
    	domingus.addNotifier(historyNotifier);
    	domingus.addCurrentNotifier(historyNotifier.getName());
    }

}