package concurrency.synchronize;

import java.util.HashMap;

/**
 *
 * @author anfeel
 * @version $ Id:Listener, v 0.1 2021年07月20日 10:31 anfeel Exp $
 */
public class Listener {
    private final Object startedWait = new Object();

    private final long startedTimeoutMilliseconds;

    private HashMap<String, Boolean> registerMap = new HashMap<>();

    public Listener(long startedTimeoutMilliseconds) {
        if (startedTimeoutMilliseconds <= 0) {
            this.startedTimeoutMilliseconds = 30000L;
        } else
            this.startedTimeoutMilliseconds = startedTimeoutMilliseconds;
    }

    public final void beforeExec(String node) {
        register(node);
        if (isAllStarted()) {
            this.doBeforeJobExecutedAtLastStarted(node);
            this.clearAll();
        } else {
            long before = System.currentTimeMillis();

            try {
                synchronized (this.startedWait) {
                    this.startedWait.wait(startedTimeoutMilliseconds);
                }
            } catch (InterruptedException e) {
                Thread.interrupted();
            }

            if (System.currentTimeMillis() - before >= this.startedTimeoutMilliseconds) {
                this.clearAll();
                System.out.println(" job timeout . timeout mills  is " + this.startedTimeoutMilliseconds);
            }
        }
    }

    private void register(String node) {
        this.registerMap.put(node, true);
    }

    private void clearAll() {
        this.registerMap.clear();
    }

    private boolean isAllStarted() {
        return false;
    }

    public final void doBeforeJobExecutedAtLastStarted(String node) {
        System.out.println(" all job started . job : " + node);
    }

    public static void main(String[] args) {
        Listener listener1 = new Listener(3000L);
        Listener listener2 = new Listener(6000L);

    }
}
