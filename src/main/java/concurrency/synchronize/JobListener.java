package concurrency.synchronize;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author anfeel
 * @version $ Id:JobListener, v 0.1 2021年07月26日 14:36 anfeel Exp $
 */
public class JobListener {

    public static HashMap<String, HashMap<Integer, Integer>> node = new HashMap<>();

    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public void registerStart(int key) {
        for (int i = 0; i < 30; i++) {
            if (node.containsKey("start") && !node.get("start").containsKey(i)) {
                HashMap start = node.get("start");
                start.put(i, 0);
                System.out.println("node : " + key + " start : " + i);
                node.put("start", start);

            }
        }
    }

    public boolean isRegisterStartSuccess() {
        for (int i = 0; i < 30; i++) {
            if (node.containsKey("start") && node.get("start").get(i) != 0)
                return false;
        }
        return true;
    }

    public void doBeforeStart(int key) {
        System.out.println(" do before start  :" + key);
    }

    public boolean isAllStarted() {
        return node.containsKey("start") && node.get("start").size() == 30;
    }


    public void clearAllStartedInfo(int key) {
        node.remove("start");
        System.out.println("clear all started info : " + key);
    }

    public void notifyWaitingTaskStart() {
        synchronized (this.startedWait) {
            this.startedWait.notifyAll();
        }
    }


    protected final Object startedWait = new Object();

    public static void main(String[] args) {
        JobListener jobListener = new JobListener();
        ExecutorService executorService = Executors.newCachedThreadPool();
        node.put("start", new HashMap<>());

        for (int i = 0; i < 30; i++) {
            int finalI = i;
            executorService.execute(() -> {
                jobListener.registerStart(finalI);

                while (!jobListener.isRegisterStartSuccess()) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                if (jobListener.isAllStarted()) {
                    jobListener.doBeforeStart(finalI);
                    jobListener.clearAllStartedInfo(finalI);
                    jobListener.notifyWaitingTaskStart();
                    return;
                }
                cachedThreadPool.execute(() -> {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    if (!node.containsKey("start"))
                        jobListener.notifyWaitingTaskStart();
                });

                long before = System.currentTimeMillis();

                try {
                    synchronized (jobListener.startedWait) {
                        jobListener.startedWait.wait(30000L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupted();
                }

                if (System.currentTimeMillis() - before >= 30000L) {
                    jobListener.clearAllStartedInfo(finalI);
                    System.out.println(" timeout  : " + finalI);
                }
            });
        }
    }
}
