package pattern.singleton;

import org.apache.commons.lang3.RandomUtils;

/**
 * 
 * @author anfeel
 * @version $Id: HungrySingleton.java, v 0.1 2020年1月8日 下午4:40:10 anfeel Exp $
 */
public class HungrySingleton {

    private static HungrySingleton hungrySingleton = null;

    private int                    num;

    private HungrySingleton() {
        num = RandomUtils.nextInt();
        //        Random r = new Random();
        //        try {
        //            Thread.sleep(r.nextInt(10000));
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
    }

    public int getNum() {
        return num;
    }

    public synchronized static HungrySingleton getInstance() {
        if (hungrySingleton == null) {
            synchronized (HungrySingleton.class) {
                if (hungrySingleton == null)
                    hungrySingleton = new HungrySingleton();
            }
        }
        return hungrySingleton;
    }
}
