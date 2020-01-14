package pattern.singleton;

/**
 * @author anfeel
 * @version pattern.singleton, v 0.1 2020/1/14 22:21 anfeel Exp $$
 */
public class BestSingleton {

    private BestSingleton() {
    }

    public BestSingleton getInstance() {
        return HolderClass.bestSingleton;
    }

    private static class HolderClass {
        private final static BestSingleton bestSingleton = new BestSingleton();
    }
}
