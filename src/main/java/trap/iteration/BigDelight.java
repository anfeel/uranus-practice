package trap.iteration;

import org.junit.Test;

/**
 * 
 * @author anfeel
 * @version $Id: BigDelight.java, v 0.1 2019年12月19日 下午6:31:02 anfeel Exp $
 */
public class BigDelight {
    @Test
    public void test1() {
        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            if (i == 0x90)
                System.out.println("Joy!");
        }
    }
}
