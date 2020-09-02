package problems.dataStructure.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:IsNumber, v 0.1 2020年09月02日 8:57 anfeel Exp $
 */
public class IsNumber {

    /**
     * A
     * A.B
     * A.B e A
     * A 是否为 带符号整数
     * B 是否为 无符号整数
     * @param s
     * @return
     */
    public boolean isNumber2(String s) {
        String[] arr = s.split("E");
        return false;
    }

    /**
     * A
     * A.B
     * A.B e A
     * A 是否为 带符号整数
     * B 是否为 无符号整数
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null)
            return false;
        s = s.trim();
        if (s.length() == 0)
            return false;
        int len = s.length();
        boolean dot = false;
        boolean e = false;
        boolean num = false;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                continue;
            if (c == '+' || c == '-') {
                if (i == len - 1 || len == 1 || !Character.isDigit(s.charAt(i + 1)) || (i > 0 && !(s.charAt(i - 1) == 'E' || s.charAt(i - 1) == 'e')))
                    return false;
            } else if (c == 'E' || c == 'e') {
                if (e || i == 0 || i == len - 1 || !Character.isDigit(s.charAt(i - 1)) || !(Character.isDigit(s.charAt(i + 1)) || s.charAt(i + 1) == '-' || s.charAt(i + 1) == '+'))
                    return false;
                else
                    e = true;
            } else if (c == '.') {
                if (dot || e || (i > 0 && !Character.isDigit(s.charAt(i - 1))) || (i < len - 1 && !Character.isDigit(s.charAt(i + 1))) || (len == 1))
                    return false;
                else
                    dot = true;
            } else
                return false;
        }
        return true;
    }

    @Test
    public void test0() {
        Assert.assertFalse(isNumber(""));
    }

    @Test
    public void test1() {
        Assert.assertTrue(isNumber("+100"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(isNumber("5e2"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(isNumber("-123"));
    }

    @Test
    public void test4() {
        Assert.assertTrue(isNumber("3.1416"));
    }

    @Test
    public void test5() {
        Assert.assertTrue(isNumber("-1E-16"));
    }

    @Test
    public void test6() {
        Assert.assertTrue(isNumber("0123"));
    }

    @Test
    public void test7() {
        Assert.assertFalse(isNumber("12e"));
    }

    @Test
    public void test8() {
        Assert.assertFalse(isNumber("1a3.14"));
    }

    @Test
    public void test9() {
        Assert.assertFalse(isNumber("1.2.3"));
    }

    @Test
    public void testa() {
        Assert.assertFalse(isNumber("+-5"));
    }

    @Test
    public void testb() {
        Assert.assertFalse(isNumber("12e+5.4"));
    }

    @Test
    public void testc() {
        Assert.assertFalse(isNumber(null));
    }

    @Test
    public void testd() {
        Assert.assertTrue(isNumber(".12"));
    }

    @Test
    public void teste() {
        Assert.assertTrue(isNumber("12e+5"));
    }

    @Test
    public void testf() {
        Assert.assertTrue(isNumber("1 "));
    }

    @Test
    public void testg() {
        Assert.assertFalse(isNumber(" "));
    }

    @Test
    public void testh() {
        Assert.assertTrue(isNumber("3."));
    }

    @Test
    public void testi() {
        Assert.assertFalse(isNumber("."));
    }

    @Test
    public void testj() {
        Assert.assertFalse(isNumber(".8+"));
    }

    @Test
    public void testk() {
        Assert.assertTrue(isNumber("+.8"));
    }

}
