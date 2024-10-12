package org.domingus.test;

import java.io.FileNotFoundException;
import java.util.List;

import org.domingus.app.Domingus;
import org.domingus.init.DomingusFactory;
import org.domingus.interfaces.Source;
import org.domingus.logger.Logger;
import org.domingus.logger.Notification;

public class MainTest {
	
	private static String EXTENSIONS_PATH = "src\\test\\resources\\extensions\\";
	private static String PATH_MEMORY = "src\\main\\resources\\memory\\memory.json";
	private static Integer TIME_INTERVAL = 1000;
	
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
    	
    	Logger logger = new Logger(PATH_MEMORY);
        List<Notification> notifications = logger.readHistory();

        System.out.println("Starting... OK");
        System.out.println("Memory size: " + notifications.size());

        for (Notification notification : notifications) {
			System.out.println(notification.getDate() + " - "+ notification.getMessage());
		}
        
    	Source source = new SourceLoggerMock(TIME_INTERVAL);
		DomingusFactory factory = new DomingusFactory();
		Domingus domingus = factory.create(source, EXTENSIONS_PATH);
		
    	domingus.addNotifier(logger);
    	domingus.addCurrentNotifier(logger.getName());

    }

}