package trap;

import org.junit.Test;

/**
 * 长整除
 * @author anfeel
 * @version $Id: LongDivision.java, v 0.1 2019年12月10日 下午4:48:36 anfeel Exp $
 */
public class LongDivision {

    @Test
    public void test1() {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }

    @Test
    public void test2() {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println((double) MICROS_PER_DAY / (double) MILLIS_PER_DAY);
    }

    @Test
    public void test3() {
        final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }
}
