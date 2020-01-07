package pattern.observer.base;

/**
 * 
 * @author anfeel
 * @version $Id: ConcreteSubject.java, v 0.1 2020年1月7日 下午12:45:40 anfeel Exp $
 */
public class ConcreteSubject extends Subject {

    /** 
     * @see pattern.observer.base.Subject#inform()
     */
    @Override
    public void inform() {
        for (Observer ob : observers) {
            ob.update();
        }
    }

}
