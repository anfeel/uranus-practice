package pattern.observer.base;

/**
 * 
 * @author anfeel
 * @version $Id: ConcreteObserver.java, v 0.1 2020年1月7日 下午12:49:53 anfeel Exp $
 */
public class ConcreteObserver implements Observer {

    private String name;

    /**
     * 
     */
    public ConcreteObserver(String name) {
        this.name = name;
    }

    /** 
     * @see pattern.observer.base.Observer#update()
     */
    @Override
    public void update() {
        System.out.println(this.name);
    }

}
