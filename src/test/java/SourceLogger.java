import java.util.HashSet;
import java.util.Set;

import org.domingus.app.ClassroomAssignment;
import org.domingus.interfaces.Observer;
import org.domingus.interfaces.Source;

public class SourceLogger  implements Source, Runnable {

    private Set<Observer> observers;
    private int version;

    public SourceLogger(Integer timeInterval) {
        observers = new HashSet<>();
        TimerLogger timer = new TimerLogger(timeInterval, this);
        Thread thread = new Thread(timer);
        thread.start();
    }

    @Override
    public void suscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void run() {
        send(new ClassroomAssignment(version++));
    }

	@Override
	public void send(ClassroomAssignment classroomAssignment) {
        observers.forEach((observer -> observer.update(classroomAssignment)));
	}

}