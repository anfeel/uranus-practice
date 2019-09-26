package org.szfs.basic.web.demo.test.concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch示例
 * 首先CountDownLatch初始化生成带有总数num的对象，执行了CountDownLatch.countDown()的线程会参与CountDownLatch的计数count
 * 若计数未完成(即count < num)，则已完成的线程会在CountDownLatch.await()前等待
 * 只有当所有的线程都计数完成(即count == num)，主线程才会继续执行
 * @author prd-fuy
 * @version $Id: CountDownLatch.java, v 0.1 2018年11月12日 上午11:07:09 prd-fuy Exp $
 */
public class CountDownLatchExample {
    public static final int num = 10;
    
    public static void main(String[] args) throws InterruptedException {
        
        final CountDownLatch latch = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            new Thread() {
                public void run() {
                    try {
                        int time = new Random().nextInt(10000);
                        System.out.println("子线程" + Thread.currentThread().getName() + "正在执行 ， 预计执行" + (float) time / 1000 + "秒");
                        Thread.sleep(time);
                        System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                        latch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        System.out.println("等待" + num + "个子线程执行完毕");
        latch.await();
        System.out.println(num + "个子线程已经执行完毕");
        System.out.println("执行主线程");
    }
}
