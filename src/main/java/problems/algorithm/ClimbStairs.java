package problems.algorithm;

import org.junit.Test;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    
    注意：给定 n 是一个正整数。
    
    示例 1：
    
    输入： 2
    输出： 2
    解释： 有两种方法可以爬到楼顶。
    1.  1 阶 + 1 阶
    2.  2 阶
    示例 2：
    
    输入： 3
    输出： 3
    解释： 有三种方法可以爬到楼顶。
    1.  1 阶 + 1 阶 + 1 阶
    2.  1 阶 + 2 阶
    3.  2 阶 + 1 阶

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: ClimbStairs.java, v 0.1 2019年11月13日 下午12:56:01 prd-fuy Exp $
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int pre = 1, cur = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;
    }
    
    @Test
    public void test1() {
        System.out.println(climbStairs(4));
    }
    
    @Test
    public void test2() {
        System.out.println(climbStairs(5));
    }
    
    @Test
    public void test3() {
        System.out.println(climbStairs(6));
    }
}
