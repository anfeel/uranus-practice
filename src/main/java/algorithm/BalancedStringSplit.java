package algorithm;

import org.junit.Test;

/**
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。

    给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
    
    返回可以通过分割得到的平衡字符串的最大数量。
    
    示例 1：
    
    输入：s = "RLRRLLRLRL"
    输出：4
    解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
    示例 2：
    
    输入：s = "RLLLLRRRLR"
    输出：3
    解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
    示例 3：
    
    输入：s = "LLLLRRRR"
    输出：1
    解释：s 只能保持原样 "LLLLRRRR".
    
    提示：
    
    1 <= s.length <= 1000
    s[i] = 'L' 或 'R'
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: BalancedStringSplit.java, v 0.1 2019年11月7日 下午4:26:57 prd-fuy Exp $
 */
public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int count = 0;
        int r = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                if (l != 0 && r != 0 && l < r) {
                    l = 0;
                    if (l % 2 == 0) {
                        count += 2;
                        r = 0;
                    } else {
                        count++;
                        r = 1;
                    }
                    continue;
                }
                r++;
                if (l < r)
                    continue;
                else if (l == r) {
                    count++;
                    l = 0;
                    r = 0;
                }
            } else if (s.charAt(i) == 'L') {
                if (l != 0 && r != 0 && r < l) {
                    r = 0;
                    if (r % 2 == 0) {
                        count += 2;
                        l = 0;
                    } else {
                        count++;
                        l = 1;
                    }
                    continue;
                }
                l++;
                if (r < l)
                    continue;
                else if (l == r) {
                    count++;
                    l = 0;
                    r = 0;
                }
            }
        }
        return count;
    }
    
    public int balancedStringSplit2(String s) {
        int num = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                num++;
            else
                num--;
            if (num == 0)
                res++;
        }
        return res;
    }
    
    @Test
    public void test1() {
        int res = balancedStringSplit2("LLLRRLLLRRLLRRRR");
        System.out.println(res);
    }
    
    @Test
    public void test2() {
        int res = balancedStringSplit2("LLLLRRRLRR");
        System.out.println(res);
    }
    
    @Test
    public void test3() {
        int res = balancedStringSplit2("RLRRLLRLRL");
        System.out.println(res);
    }
    
    @Test
    public void test4() {
        int res = balancedStringSplit2("RLLLLRRRLR");
        System.out.println(res);
    }
    
    @Test
    public void test5() {
        int res = balancedStringSplit2("LLLLRRRR");
        System.out.println(res);
    }
    
    @Test
    public void test6() {
        int res = balancedStringSplit2("RLLRRLLRRL");
        System.out.println(res);
    }
    
    @Test
    public void test7() {
        int res = balancedStringSplit2("RLLLRRRLLLRRRL");
        System.out.println(res);
    }
    
    @Test
    public void test8() {
        int res = balancedStringSplit2("RLRRRLLRLL");
        System.out.println(res);
    }
    
}
