package trap.expression;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * 找零时刻
 * @author anfeel
 * @version $Id: CashChange.java, v 0.1 2019年12月10日 上午11:11:33 anfeel Exp $
 */
public class CashChange {

    @Test
    public void test1() {
        System.out.println(2.00 - 1.10);
    }

    @Test
    public void test2() {
        System.out.println((float) 2.00 - (float) 1.10);
    }

    @Test
    public void test3() {
        System.out.printf("%.2f%n", 2.00 - 1.10);
    }

    @Test
    public void test4() {
        System.out.println((200 - 110) + "cents");
    }

    @Test
    public void test5() {
        BigDecimal a = new BigDecimal(2.00);
        BigDecimal b = new BigDecimal(1.10);
        System.out.println(a.subtract(b));
    }

    @Test
    public void test6() {
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
    }
}
