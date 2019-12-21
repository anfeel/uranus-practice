package trap.expression;

import org.junit.Test;

/**
 * 多重转型
 * @author anfeel
 * @version $Id: Multicaset.java, v 0.1 2019年12月19日 下午6:21:15 anfeel Exp $
 */
public class Multicaset {
    @Test
    public void test1() {
        System.out.println((int) (char) (byte) -1);
    }
}
