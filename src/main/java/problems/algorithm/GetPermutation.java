package problems.algorithm;

import org.junit.Test;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 3: 2*3
 * 9 - 6 = 3
 * 2: 2*1
 * 3 - 2 = 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:GetPermutation, v 0.1 2020年09月05日 10:07 anfeel Exp $
 */
public class GetPermutation {

    public String getPermutation(int n, int k) {
        if (n < 1 || k < 1)
            return "";
        String res = permute(n, n - 1, k, new boolean[n + 1]);
        return res;
    }


    public String permute(int n, int cur, int nk, boolean[] status) {
        //当前剩余数字做阶乘的序列个数
        int f = factorial(cur);
        for (int j = 1; j <= n; j++) {
            if (status[j]) {
                continue;
            }
            if (nk > f) {
                //剩余的序列个数
                nk = nk - f;
                continue;
            }
            status[j] = true;
            return j + permute(n, cur - 1, nk, status);
        }
        return "";
    }


    public int factorial(int n) {
        if (n > 1)
            return n * factorial(n - 1);
        else
            return 1;
    }

    @Test
    public void test1() {
        System.out.println(getPermutation(3, 3));
    }

    @Test
    public void test2() {
        System.out.println(getPermutation(4, 9));
    }

    @Test
    public void test3() {
        System.out.println(getPermutation(1, 1));
    }

    @Test
    public void test4() {
        System.out.println(getPermutation(1, 2));
    }

    @Test
    public void test5() {
        System.out.println(getPermutation(1, 0));
    }

    @Test
    public void test6() {
        System.out.println(getPermutation(0, 2));
    }

    @Test
    public void test7() {
        System.out.println(getPermutation(2, 2));
    }
}
