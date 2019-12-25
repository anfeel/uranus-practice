package problems.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 *  find all unique combinations in candidates where the candidate numbers sums to target.
    
    The same repeated number may be chosen from candidates unlimited number of times.
    
    Note:
    
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
    Example 1:
    
    Input: candidates = [2,3,6,7], target = 7,
    A solution set is:
    [
      [7],
      [2,2,3]
    ]
    Example 2:
    
    Input: candidates = [2,3,5], target = 8,
    A solution set is:
    [
      [2,2,2,2],
      [2,3,3],
      [3,5]
    ]
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/combination-sum
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: CombinationSum.java, v 0.1 2019年12月21日 下午9:10:30 anfeel Exp $
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        getCombination(res, new Stack<>(), 0, candidates, target);
        return res;
    }

    public void getCombination(List<List<Integer>> res, Stack<Integer> stack, int curPos, int[] can, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(stack));
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = curPos; i < can.length; i++) {
            int tar = target - can[i];
            stack.add(can[i]);
            getCombination(res, stack, i, can, tar);
            stack.pop();
        }
    }

    @Test
    public void test1() {
        int[] arr = new int[] { 2, 3, 6, 7 };
        List<List<Integer>> res = combinationSum(arr, 7);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d , ", i);
            }
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[] { 2, 3, 5 };
        List<List<Integer>> res = combinationSum(arr, 8);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d , ", i);
            }
        }
    }

    @Test
    public void test3() {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
        List<List<Integer>> res = combinationSum(arr, 10);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d , ", i);
            }
        }
    }

    @Test
    public void test4() {
        int[] arr = new int[] {};
        List<List<Integer>> res = combinationSum(arr, 10);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d , ", i);
            }
        }
    }

    @Test
    public void test5() {
        int[] arr = new int[] { 1, 3 };
        List<List<Integer>> res = combinationSum(arr, 2);
        for (List<Integer> l : res) {
            System.out.println();
            for (int i : l) {
                System.out.printf(" %d , ", i);
            }
        }
    }
}
