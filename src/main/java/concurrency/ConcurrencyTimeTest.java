package concurrency;

/**
 * 串行和并行执行，比较累加操作时间
 * @author prd-fuy
 * @version $Id: ConcurrencyTest.java, v 0.1 2019年9月20日 上午10:12:38 prd-fuy Exp $
 */
public class ConcurrencyTimeTest {
    
    private static final long count = 100000000l;
    
    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }
    
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++)
            b--;
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("Concurrency : " + time + "ms,b=" + b);
    }
    
    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++)
            b--;
        long time = System.currentTimeMillis() - start;
        System.out.println("serial : " + time + "ms, b=" + b + ", a=" + a);
    }
}