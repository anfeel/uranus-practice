package concurrency.synchronize;

/**
 *
 * @author anfeel
 * @version $ Id:SynchronizedDemo, v 0.1 2021年06月23日 15:25 anfeel Exp $
 */
public class SynchronizedDemo {

    public synchronized void normalMethod() {
        doPrint(5);
    }

    public void blockedMethod() {
        synchronized (this) {
            doPrint(5);
        }
    }

    public static void doPrint(int index) {
        while (index-- > 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "--->" + index);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo d = new SynchronizedDemo();
        new Thread(() -> d.normalMethod(), "testNormalMethod").start();
        new Thread(() -> d.blockedMethod(), "testBlockMethod").start();
    }

}
