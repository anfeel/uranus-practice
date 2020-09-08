package problems.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:Combine, v 0.1 2020年09月08日 8:48 anfeel Exp $
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0 || n < k)
            return res;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            process(i, n, k, res, stack);
            stack.pop();
        }
        return res;
    }

    public void process(int start, int n, int k, List<List<Integer>> res, Stack<Integer> stack) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start + 1; i <= n; i++) {
            stack.push(i);
            process(i, n, k, res, stack);
            stack.pop();
        }
    }

    @Test
    public void test1() {
        List<List<Integer>> res = combine(4, 2);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d ", i);
            }
        }
    }

    @Test
    public void test2() {
        List<List<Integer>> res = combine(4, 5);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d ", i);
            }
        }
    }

    @Test
    public void test3() {
        List<List<Integer>> res = combine(4, 3);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d ", i);
            }
        }
    }

    @Test
    public void test4() {
        List<List<Integer>> res = combine(6, 3);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d ", i);
            }
        }
    }

    @Test
    public void test5() {
        List<List<Integer>> res = combine(3, 3);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d ", i);
            }
        }
    }

    @Test
    public void test6() {
        List<List<Integer>> res = combine(0, 3);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d ", i);
            }
        }
    }

    @Test
    public void test7() {
        List<List<Integer>> res = combine(3, 0);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d ", i);
            }
        }
    }

    @Test
    public void test8() {
        List<List<Integer>> res = combine(0, 0);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d ", i);
            }
        }
    }
}
