package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * 
    Given a collection of distinct integers, return all possible permutations.
    
    Example:
    
    Input: [1,2,3]
    Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/permutations
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: Permute.java, v 0.1 2019年12月13日 上午10:40:33 anfeel Exp $
 */
public class Permute {

    /**
     * 回溯：深度优先遍历+状态重置+剪枝
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (len == 0)
            return res;
        getPermutation(res, nums, new int[len], new Stack<>());
        return res;
    }

    public void getPermutation(List<List<Integer>> res, int[] nums, int[] status, Stack<Integer> stack) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
        }
        for (int i = 0; i < nums.length; i++) {
            if (status[i] != 1) {
                status[i] = 1;
                stack.push(nums[i]);
                getPermutation(res, nums, status, stack);
                stack.pop();
                status[i] = 0;
            }
        }
    }

    @Test
    public void test1() {
        int[] arr = new int[] { 1, 2, 3 };
        List<List<Integer>> res = permute(arr);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d , ", i);
            }
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[] { 1, 2, 3, 4 };
        List<List<Integer>> res = permute(arr);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d , ", i);
            }
        }
    }

    @Test
    public void test3() {
        int[] arr = new int[] {};
        List<List<Integer>> res = permute(arr);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d , ", i);
            }
        }
    }
}
