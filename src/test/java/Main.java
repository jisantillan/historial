import java.io.IOException;

import org.domingus.app.Domingus;
import org.domingus.init.DomingusFactory;
import org.domingus.interfaces.Source;
import org.domingus.logger.Logger;
import org.domingus.init.LoggerFactory;

public class Main {
	
	private static String EXTENSIONS_PATH = "src\\test\\resources\\extensions\\";
	private static String PATH_MEMORY = "src\\test\\resources\\memory.txt";
	private static Integer TIME_INTERVAL = 2000;
	
    public static void main(String[] args) throws IOException {
    	System.out.println("Init App");
    	LoggerFactory loggerFactory = new LoggerFactory();
    	Logger logger = loggerFactory.create(PATH_MEMORY);
        
    	DomingusFactory domingusFactory = new DomingusFactory();
    	Source source = new SourceLogger(TIME_INTERVAL);
		Domingus domingus = domingusFactory.create(source, EXTENSIONS_PATH);
		
    	domingus.addObserver(logger);
    	domingus.addCurrentObserver(logger.getClass().getSimpleName());
    }

}