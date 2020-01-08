package pattern.singleton;

import org.apache.commons.lang3.RandomUtils;

/**
 * 单例模式
 * 1. 私有构造方法，防止外部类调用
 * 2. 私有静态对象实例，实例只会在类初始化后进行构造
 * 3. 公有静态方法获取私有实例
 * @author anfeel
 * @version $Id: MySingleton.java, v 0.1 2020年1月7日 下午2:43:30 anfeel Exp $
 */
public class MySingleton {

    private int                num;

    //why set private instance to null ?
    private static MySingleton mySingleton = null;

    private MySingleton() {
        num = RandomUtils.nextInt();
    }

    public int getNum() {
        return this.num;
    }

    public static MySingleton getInstance() {
        if (mySingleton == null)
            mySingleton = new MySingleton();
        return mySingleton;
    }
}
