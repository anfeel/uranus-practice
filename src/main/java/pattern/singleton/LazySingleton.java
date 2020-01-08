package pattern.singleton;

import org.apache.commons.lang3.RandomUtils;

/**
 * 
 * @author anfeel
 * @version $Id: LazySingleton.java, v 0.1 2020年1月8日 下午4:26:29 anfeel Exp $
 */
public class LazySingleton {

    private static final LazySingleton lazySingleton = new LazySingleton();

    private int                        num;

    private LazySingleton() {
        num = RandomUtils.nextInt();
    }

    public int getNum() {
        return num;
    }

    public static LazySingleton getInstance() {
        return lazySingleton;
    }
}
