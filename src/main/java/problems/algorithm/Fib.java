package problems.algorithm;

import org.junit.Test;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
    给定 N，计算 F(N)。
    
    示例 1：
    
    输入：2
    输出：1
    解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
    示例 2：
    
    输入：3
    输出：2
    解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
    示例 3：
    
    输入：4
    输出：3
    解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
     
    
    提示：
    
    0 ≤ N ≤ 30
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/fibonacci-number
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: Fib.java, v 0.1 2019年11月8日 下午4:09:00 prd-fuy Exp $
 */
public class Fib {
    public int fib(int N) {
        if (N < 2)
            return N;
        return fib(N - 2) + fib(N - 1);
    }
    
    public int fibo(int N) {
        if (N < 2)
            return N;
        int pre = 0, cur = 1;
        for (int i = 1; i < N; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
    
    @Test
    public void test1() {
        System.out.println(fibo(2));
    }
    
    @Test
    public void test2() {
        System.out.println(fibo(3));
    }
    
    @Test
    public void test3() {
        
        System.out.println(fibo(4));
    }
    
    @Test
    public void test4() {
        
        long start1 = System.currentTimeMillis();
        System.out.println(fib(30));
        long end1 = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (end1 - start1) + "ms");
        
    }
    
    @Test
    public void test5() {
        long start2 = System.currentTimeMillis();
        System.out.println(fibo(30));
        long end2 = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (end2 - start2) + "ms");
    }
}
