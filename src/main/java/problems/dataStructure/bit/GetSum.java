package problems.dataStructure.bit;

import org.junit.Test;

/**
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

    示例 1:
    
    输入: a = 1, b = 2
    输出: 3
    示例 2:
    
    输入: a = -2, b = 3
    输出: 1
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/sum-of-two-integers
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: GetSum.java, v 0.1 2019年11月7日 上午10:49:56 prd-fuy Exp $
 */
public class GetSum {
    public int getSum(int a, int b) {
        int c = a ^ b;
        int d = (a & b) << 1;
        if (d != 0)
            return getSum(c, d);
        return c;
    }
    
    @Test
    public void test1() {
        int a = -1801, b = 1800;
        System.out.println(getSum(a, b));
    }
    
    @Test
    public void test2() {
        int a = 1801123123, b = 1801123123;
        System.out.println(getSum(a, b));
    }
    
    @Test
    public void test3() {
        int a = -1, b = 1;
        System.out.println(getSum(a, b));
    }
    
    @Test
    public void test4() {
        int a = 5, b = 3;
        System.out.println(getSum(a, b));
    }
}
