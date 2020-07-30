package problems.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 输入: 9
 * 输出: 27
 * 解释: 9 = 3 + 3 + 3, 3 × 3 × 3 = 36。
 *
 * 输入: 11
 * 输出: 48
 * 解释: 11 = 4 + 4 + 3, 4 × 4 × 3 = 48。
 *
 * 4:4, 5:6, 6:9 ,7:12,8:18,9:27,10:36,11:48,12:81,13:108,14:162,15:243,16:324
 * 4=2*2,5=3*2,6=3*3,7=3*2*2,8=3*3*3
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $ Id:IntegerBreak, v 0.1 2020年07月30日 9:31 anfeel Exp $
 */
public class IntegerBreak {
    @Test
    public void test0() {
        System.out.println(integerBreak(17));
    }

    @Test
    public void test1() {
        Assert.assertEquals(36, integerBreak(10));
    }

    @Test
    public void test2() {
        Assert.assertEquals(54, integerBreak(11));
    }

    @Test
    public void test3() {
        Assert.assertEquals(81, integerBreak(12));
    }

    @Test
    public void test4() {
        Assert.assertEquals(108, integerBreak(13));
    }

    @Test
    public void test5() {
        Assert.assertEquals(162, integerBreak(14));
    }

    @Test
    public void test6() {
        Assert.assertEquals(243, integerBreak(15));
    }

    @Test
    public void test7() {
        Assert.assertEquals(324, integerBreak(16));
    }

    @Test
    public void test8() {
        Assert.assertEquals(3, integerBreak(3));
    }

    @Test
    public void test9() {
        Assert.assertEquals(4, integerBreak(4));
    }

    @Test
    public void testa() {
        Assert.assertEquals(6, integerBreak(5));
    }

    @Test
    public void testb() {
        Assert.assertEquals(9, integerBreak(6));
    }

    @Test
    public void testc() {
        Assert.assertEquals(1, integerBreak(1));
    }

    @Test
    public void testd() {
        Assert.assertEquals(1, integerBreak(2));
    }

    @Test
    public void teste() {
        Assert.assertEquals(2, integerBreak(3));
    }

    public int integerBreak(int n) {
        if (n <= 2)
            return 1;
        if (n == 3)
            return 2;
        int res = 1;
        int m = n % 3;
        if (m == 0) {
            int p = n / 3;
            for (int i = 0; i < p; i++) {
                res *= 3;
            }
        } else if (m == 1) {
            int p = (n / 3) - 1;
            int r = 0;
            for (int i = 0; i < p; i++) {
                res *= 3;
                r += 3;
            }
            int q = (n - r) / 2;
            for (int i = 0; i < q; i++) {
                res *= 2;
            }
        } else if (m == 2) {
            int p = (n / 3);
            for (int i = 0; i < p; i++) {
                res *= 3;
            }
            res *= 2;
        }
        return res;
    }
}
