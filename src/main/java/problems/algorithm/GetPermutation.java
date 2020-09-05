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
        boolean[] status = new boolean[n];
        int f = 0;
        int num = 0;
        int nk = k;
        String res = "";
        for (int i = 0; i < n; i++) {
            f = factorial(n - 1);
            num = nk / f;
            int t = i + num;
            status[t] = true;
        }
        return null;
    }

    public String getPermutation2(int n, int k) {
        n = 4;
        k = 9;
        int f1 = factorial(4 - 1);//f1 = 6
        int num1 = k / f1;//num1 = 1
        int nextK = k % f1;//nextK = 3

        int f2 = factorial(3 - 1);//f2 = 2
        int num2 = nextK / f2;//num2= 1;
        int nextK2 = nextK % f2;//nextK2 = 1

        int f3 = factorial(2 - 1);//f3 = 1
        int nextK3 = nextK2 % f3;//nextK3 =0

        return null;
    }


    public int factorial(int n) {
        if (n != 1)
            return n * factorial(n - 1);
        return 1;
    }

    @Test
    public void test1() {
        System.out.println(factorial(3));
    }
}
