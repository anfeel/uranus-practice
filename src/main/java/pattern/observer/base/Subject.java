package pattern.observer.base;

import java.util.ArrayList;

/**
 * 
 * @author anfeel
 * @version $Id: Subject.java, v 0.1 2020年1月7日 下午12:36:08 anfeel Exp $
 */
public abstract class Subject {

    protected ArrayList<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public abstract void inform();
}
