package pattern.observer.multiplayer;

/**
 * 
 * @author anfeel
 * @version $Id: ConcreteAllyControlCneter.java, v 0.1 2020年1月7日 下午1:45:18 anfeel Exp $
 */
public class ConcreteAllyControlCneter extends AllyControlCenter {

    public ConcreteAllyControlCneter(String allyName) {
        this.allyName = allyName;
        System.out.println("[" + this.allyName + "] team is done");
    }

    /** 
     * @see pattern.observer.multiplayer.AllyControlCenter#notifyObserver()
     */
    @Override
    public void notifyObserver(String name) {
        for (Observer s : players) {
            if (!s.getName().equals(name)) {
                s.help();
            }
        }
    }

}
