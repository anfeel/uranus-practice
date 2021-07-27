package concurrency.synchronize;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author anfeel
 * @version $ Id:ElasticJobListener, v 0.1 2021年07月26日 15:11 anfeel Exp $
 */
public class ElasticJobListener {

    public static HashMap<String, HashMap<Integer, Integer>> node = new HashMap<>();

    public void registerStart() {
        for (int i = 0; i < 30; i++) {
            if (node.containsKey("start") && !node.get("start").containsKey(i)) {
                HashMap start = node.get("start");
                start.put(i, 0);
                node.put("start", start);
            }
        }
    }

    public boolean isRegisterStartSuccess() {
        for (int i = 0; i < 30; i++) {
            if (node.get("start").get(i) != 0)
                return false;
        }
        return true;
    }

    public void doBeforeStart(int key) {
        notifyWaitingTaskStart();
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
        ElasticJobListener jobListener = new ElasticJobListener();
        node.put("start", new HashMap<>());
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            executorService.execute(() -> {
                jobListener.registerStart();

                if (jobListener.isAllStarted()) {
                    jobListener.doBeforeStart(finalI);
                    jobListener.clearAllStartedInfo(finalI);
                } else {

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
                }
            });
        }
    }
}
