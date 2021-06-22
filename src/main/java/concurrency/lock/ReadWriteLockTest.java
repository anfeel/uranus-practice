package concurrency.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author anfeel
 * @version $ Id:ReadWriteLockTest, v 0.1 2021年06月22日 11:04 anfeel Exp $
 */
public class ReadWriteLockTest {

    ReadWriteLock rwl = new ReentrantReadWriteLock();

    public void read(Thread thread) {
        rwl.readLock().lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("thread : " + thread.getName() + " , reading " + i);
            }
            System.out.println("thread : " + thread.getName() + " , reading finish");
        } finally {
            rwl.readLock().unlock();
        }
    }

    public void write(Thread thread) {
        rwl.writeLock().lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("thread : " + thread.getName() + " , writing " + i);
            }
            System.out.println("thread : " + thread.getName() + " , writing finish");
        } finally {
            rwl.writeLock().unlock();
        }
    }


    public static void main(String[] args) {
        ReadWriteLockTest test = new ReadWriteLockTest();
        ExecutorService pool = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            pool.execute(() -> {
                if (finalI % 2 == 0) {
                    test.read(Thread.currentThread());
                    test.write(Thread.currentThread());
                } else {
                    test.write(Thread.currentThread());
                    test.read(Thread.currentThread());
                }
            });
        }
        pool.shutdown();
    }
}
