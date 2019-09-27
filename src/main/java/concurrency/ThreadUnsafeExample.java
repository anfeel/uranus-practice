package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * 
 * @author prd-fuy
 * @version $Id: ThreadUnsafeExample.java, v 0.1 2018年11月12日 下午3:53:44 prd-fuy Exp $
 */
public class ThreadUnsafeExample {
    
    private int  count = 0;
    
    private Lock lock  = new ReentrantLock();
    
    public void add() {
        count++;
    }
    
    public void addWithLock() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
    
    public int get() {
        return count;
    }
    
    @Test
    public void test1() throws InterruptedException {
        final int threadSize = 10000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        //        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    example.add();
                }
            });
        }
        //        countDownLatch.await();
        executorService.shutdown();
        long time = System.currentTimeMillis() - start;
        System.out.println("Time = " + time + "ms , " + example.get());
    }
    
    @Test
    public void test2() throws InterruptedException {
        final int threadSize = 10000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        //        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    example.add();
                }
            });
        }
        //        countDownLatch.await();
        executorService.shutdown();
        long time = System.currentTimeMillis() - start;
        System.out.println("Time = " + time + "ms , " + example.get());
    }
    
    @Test
    public void test3() throws InterruptedException {
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    example.addWithLock();
                }
            });
        }
        executorService.shutdown();
        long time = System.currentTimeMillis() - start;
        System.out.println("Time = " + time + "ms , " + example.get());
    }
}
