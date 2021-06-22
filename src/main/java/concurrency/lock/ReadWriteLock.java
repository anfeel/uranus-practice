package concurrency.lock;

/**
 *
 * @author anfeel
 * @version $ Id:ReadWriteLock, v 0.1 2021年06月22日 9:27 anfeel Exp $
 */
public class ReadWriteLock {

    private int readers;

    private int writers;

    private int writeRequests;

    public synchronized void lockRead() throws InterruptedException {
        while (writers > 0 || writeRequests > 0) {
            wait();
        }
        readers++;
    }

    public synchronized void unlockRead() {
        readers--;
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        writeRequests++;
        while (readers > 0 || writers > 0 || writeRequests > 0) {
            wait();
        }
        writeRequests--;
        writers++;
    }

    public synchronized void unlockWrite() {
        writers--;
        notifyAll();

    }
}
