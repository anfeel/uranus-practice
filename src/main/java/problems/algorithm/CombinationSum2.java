package problems.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 示例 3:
 * 输入: candidates = [2,5,2,1,3,2,4,6], target = 9
 *  [2,1,6]
 *  [2,5,2]
 *  [2,2,3,2]
 *  [2,3,4]
 *  [5,1,3]
 *  [5,4]
 *  [6,3]
 *
 * 输入: candidates = [1,2,2,2,3,4,5,6], target = 9
 *  [1,2,2,4]
 *  [1,2,6]
 *  [1,3,5]
 *  [2,2,2,3]
 *  [2,2,5]
 *  [2,3,4]
 *  [3,6]
 *  [4,5]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:CombinationSum2, v 0.1 2020年09月10日 9:27 anfeel Exp $
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target == 0)
            return list;
        Arrays.sort(candidates);
        getSum(candidates, 0, target, list, new Stack<Integer>());
        return null;
    }

    public void getSum(int[] can, int curPos, int target, List<List<Integer>> list, Stack<Integer> stack) {
        if (target == 0) {
            list.add(new ArrayList<>(stack));
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = curPos; i < can.length; i++) {
            stack.push(can[i]);
            getSum(can, curPos, target - can[i], list, stack);
            stack.pop();
        }
    }
}
