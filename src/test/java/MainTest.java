import java.io.FileNotFoundException;

import org.domingus.app.Domingus;
import org.domingus.init.DomingusFactory;
import org.domingus.interfaces.Source;
import org.domingus.logger.LogNotifier;
import org.domingus.init.LogNotifierFactory;

public class MainTest {
	
	private static String EXTENSIONS_PATH = "src\\test\\resources\\extensions\\";
	private static String PATH_MEMORY = "src\\test\\resources\\memory.json";
	private static Integer TIME_INTERVAL = 1000;
	
    public static void main(String[] args) throws  FileNotFoundException {
    	System.out.println("Init App");
    	LogNotifierFactory logNotifierFactory = new LogNotifierFactory();
    	LogNotifier logNotifier = logNotifierFactory.create(PATH_MEMORY);
        
    	DomingusFactory domingusFactory = new DomingusFactory();
    	Source source = new SourceLogger(TIME_INTERVAL);
		Domingus domingus = domingusFactory.create(source, EXTENSIONS_PATH);
		
    	domingus.addObserver(logNotifier);
    	//domingus.addCurrentNotifier(logNotifier);
    }

}