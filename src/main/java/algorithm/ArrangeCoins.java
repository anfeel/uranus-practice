package algorithm;

import org.junit.Test;

/**
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。

    给定一个数字 n，找出可形成完整阶梯行的总行数。
    
    n 是一个非负整数，并且在32位有符号整型的范围内。
    
    示例 1:
    
    n = 5
    
    硬币可排列成以下几行:
    ¤
    ¤ ¤
    ¤ ¤
    
    因为第三行不完整，所以返回2.
    示例 2:
    
    n = 8
    
    硬币可排列成以下几行:
    ¤
    ¤ ¤
    ¤ ¤ ¤
    ¤ ¤
    
    因为第四行不完整，所以返回3.
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/arranging-coins
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: ArrangeCoins.java, v 0.1 2019年10月31日 下午4:00:57 prd-fuy Exp $
 */
public class ArrangeCoins {
    
    public int arrangeCoins(int n) {
        int last = (n - 1) / 2;
        int sum = 0, count = 0;
        for (int i = last; i > 0; i--) {
            sum += i;
            count++;
        }
        if (n - sum == 0)
            count++;
        return count;
    }
    
    public int arrangeCoins2(int n) {
        int m = (int) Math.sqrt(2 * n);
        return m;
        
    }
    
    @Test
    public void test1() {
        for (int i = 0; i < 70; i++) {
            System.out.println(" i = " + i + ", res = " + arrangeCoins2(i));
        }
    }
    
    @Test
    public void test2() {
        int n = 62;
        int m = (int) Math.sqrt(2 * n) - 1;
        System.out.println(" n = " + n + " m = " + m);
    }
    
}
