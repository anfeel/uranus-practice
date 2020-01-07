package pattern.observer.multiplayer;

import java.util.ArrayList;

/**
 * 
 * @author anfeel
 * @version $Id: AllyControlCenter.java, v 0.1 2020年1月7日 下午1:43:05 anfeel Exp $
 */
public abstract class AllyControlCenter {

    String              allyName;

    ArrayList<Observer> players = new ArrayList<>();;

    /**
     * Getter method for property <tt>allyName</tt>.
     * 
     * @return property value of allyName
     */
    public String getAllyName() {
        return allyName;
    }

    /**
     * Setter method for property <tt>allyName</tt>.
     * 
     * @param allyName value to be assigned to property allyName
     */
    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    public void join(Observer observer) {
        System.out.println(observer.getName() + " join [" + this.allyName + "] team");
        players.add(observer);
    }

    public void quit(Observer observer) {
        System.out.println(observer.getName() + " quit [" + this.allyName + "] team");
        players.remove(observer);
    }

    public abstract void notifyObserver(String name);
}
