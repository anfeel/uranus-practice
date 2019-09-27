package concurrency;

import java.util.concurrent.Semaphore;

import org.apache.commons.lang3.RandomUtils;

/**
 * 
 * @author prd-fuy
 * @version $Id: SemaphoreExample.java, v 0.1 2018年11月12日 下午12:58:17 prd-fuy Exp $
 */
public class SemaphoreExample {
    class Worker extends Thread {
        private int       num;
        private Semaphore semaphore;
        
        /**
         * 
         */
        public Worker() {
            
        }
        
        /**
         * @param num
         * @param semaphore
         */
        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }
        
        /** 
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            try {
                semaphore.acquire();
                int proTime = 2000 + RandomUtils.nextInt(0, 2000);
                System.out.println("工人" + this.num + "占用机器 ， 时间 = " + proTime);
                Thread.sleep(proTime);
                System.out.println("工人" + this.num + "要释放一个机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        int num = 8;
        SemaphoreExample semaphoreExample = new SemaphoreExample();
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < num; i++) {
            semaphoreExample.new Worker(i, semaphore).start();
            
        }
        
    }
}
