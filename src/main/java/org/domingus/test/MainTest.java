package org.domingus.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.domingus.app.Domingus;
import org.domingus.interfaces.Source;
import org.domingus.logger.Logger;
import org.domingus.logger.Notification;

public class MainTest {
	
	private static String PATH_EXTENSIONS = "src\\main\\resources\\extensions\\";
	private static String PATH_MEMORY = "src\\main\\resources\\memory\\memory.json";
	
    public static void main(String[] args) throws InterruptedException {
    	
    	Logger logger = new Logger(PATH_MEMORY);
        List<Notification> notifications = logger.readHistory();

        System.out.println("Starting... done");
        System.out.println("Memory size: " + notifications.size());

        for (Notification notification : notifications) {
			System.out.println(notification.getDate() + " - "+ notification.getMessage());
		}
        
    	Source source = new SourceLoggerMock(3000);
    	Domingus domingus = new Domingus(source);
    	domingus.addObserver(logger);
    	
    	try {
    		domingus.init(PATH_EXTENSIONS);
		} catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException
				| IllegalAccessException | InterruptedException | IOException e) {
			e.printStackTrace();
		}

    }

}