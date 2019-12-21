package trap.expression;

import org.junit.Test;

/**
 * 奇数性
 * @author anfeel
 * @version $Id: IsOdd.java, v 0.1 2019年12月10日 上午11:00:30 anfeel Exp $
 */
public class IsOdd {

    public static boolean isOdd(int i) {
        return (i & 1) != 0;
        //        return i % 2 != 0;
        //        return i % 2 == -1 || i % 2 == 1;
        //        return i % 2 == 1;
    }

    @Test
    public void test1() {
        System.out.println(isOdd(1));
    }

    @Test
    public void test2() {
        System.out.println(isOdd(2));
    }

    @Test
    public void test3() {
        System.out.println(isOdd(-3));
    }

    @Test
    public void test4() {
        System.out.println(isOdd(0));
    }

}
