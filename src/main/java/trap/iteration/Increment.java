package trap.iteration;

import org.junit.Test;

/**
 * 无情的增量操作
 * @author anfeel
 * @version $Id: Increment.java, v 0.1 2019年12月19日 下午6:39:47 anfeel Exp $
 */
public class Increment {

    @Test
    public void test1() {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
            System.out.println(j);
        }
    }
}
