package pattern.observer.base;

/**
 * 
 * @author anfeel
 * @version $Id: ObserverSample.java, v 0.1 2020年1月7日 下午12:51:42 anfeel Exp $
 */
public class ObserverSample {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer s1 = new ConcreteObserver("s1");
        Observer s2 = new ConcreteObserver("s2");
        Observer s3 = new ConcreteObserver("s3");
        subject.attach(s1);
        subject.attach(s2);
        subject.attach(s3);
        subject.inform();
    }
}
