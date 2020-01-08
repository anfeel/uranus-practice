package pattern.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * 
 * @author anfeel
 * @version $Id: SingletonTest.java, v 0.1 2020年1月8日 下午4:24:48 anfeel Exp $
 */
public class SingletonTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    //                    System.out.println(MySingleton.getInstance().getNum());
                    //                    System.out.println(LazySingleton.getInstance().getNum());
                    System.out.println(HungrySingleton.getInstance().getNum());
                }
            });
        }
    }

    @Test
    public void test1() throws InterruptedException {
        int nums = 100000;
        final CountDownLatch latch = new CountDownLatch(nums);
        long start = System.currentTimeMillis();
        for (int i = 0; i < nums; i++) {
            new Thread() {
                public void run() {
                    HungrySingleton.getInstance().getNum();
                    latch.countDown();
                }
            }.start();
        }
        latch.await();
        long time = System.currentTimeMillis() - start;
        System.out.println(" HungrySingleton :" + time);
    }

    @Test
    public void test2() throws InterruptedException {
        int nums = 100000;
        final CountDownLatch latch = new CountDownLatch(nums);
        long start = System.currentTimeMillis();
        for (int i = 0; i < nums; i++) {
            new Thread() {
                public void run() {
                    LazySingleton.getInstance().getNum();
                    latch.countDown();
                }
            }.start();
        }
        latch.await();
        long time = System.currentTimeMillis() - start;
        System.out.println(" LazySingleton :" + time);
    }

}
