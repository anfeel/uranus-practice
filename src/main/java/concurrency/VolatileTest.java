package concurrency;

/**
 *
 * @author anfeel
 * @version $ Id:VolatileTest, v 0.1 2021年06月23日 13:06 anfeel Exp $
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
//        System.out.println(race);
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }

//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }

        Thread.sleep(3000);
        System.out.println(race);
    }

}
