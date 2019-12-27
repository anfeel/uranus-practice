package problems.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

    说明：解集不能包含重复的子集。
    
    示例:
    
    输入: nums = [1,2,3]
    输出:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/subsets
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: Subsets.java, v 0.1 2019年12月13日 上午11:08:31 anfeel Exp $
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getSubset(res, new Stack<>(), 0, nums);
        return res;
    }

    public void getSubset(List<List<Integer>> list, Stack<Integer> stack, int cur, int nums[]) {
        if (stack.size() > nums.length)
            return;
        list.add(new ArrayList<>(stack));
        for (int i = cur; i < nums.length; i++) {
            stack.add(nums[i]);
            getSubset(list, stack, i + 1, nums);
            stack.pop();
        }
    }

    public void print(List<List<Integer>> res) {
        for (List<Integer> list : res) {
            System.out.println();
            for (Integer integer : list) {
                System.out.printf(" %d ", integer);
            }
        }
    }

    @Test
    public void test1() {
        int[] arr = new int[] { 2, 3, 6, 7 };
        List<List<Integer>> res = subsets(arr);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d , ", i);
            }
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[] { 1, 2, 3 };
        List<List<Integer>> res = subsets(arr);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d , ", i);
            }
        }
    }

    @Test
    public void test3() {
        int[] arr = new int[] { 1 };
        List<List<Integer>> res = subsets(arr);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d , ", i);
            }
        }
    }
}
