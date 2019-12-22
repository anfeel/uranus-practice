package problems.dataStructure.array;

import java.util.HashMap;

import org.junit.Test;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
    
    示例:
    
    给定 nums = [2, 7, 11, 15], target = 9
    
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/two-sum
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: TwoSum.java, v 0.1 2019年10月28日 下午3:08:31 prd-fuy Exp $
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2)
            return null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
    
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> minus = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            if (minus.containsKey(nums[i])) {
                return new int[] { minus.get(nums[i]), map.get(nums[i]) };
            } else {
                minus.put(target - nums[i], i);
            }
        }
        return null;
    }
    
    public void printArr(int[] result) {
        if (result == null)
            System.out.println(" arr is null ");
        else {
            for (int i = 0; i < result.length; i++) {
                System.out.printf(" %d ", result[i]);
            }
            
        }
    }
    
    @Test
    public void test1() {
        int[] input = { 2, 7, 11, 15 };
        System.out.println("\n input : ");
        printArr(input);
        int[] result = twoSum2(input, 9);
        System.out.println("\n result arr: ");
        printArr(result);
    }
    
    @Test
    public void test2() {
        int[] input = { 1, 7, 11, 15 };
        System.out.println("\n input : ");
        printArr(input);
        int[] result = twoSum2(input, 9);
        System.out.println("\n result arr: ");
        printArr(result);
    }
    
    @Test
    public void test3() {
        int[] input = { 2, 3, 4, 7, 11, 15 };
        System.out.println("\n input : ");
        printArr(input);
        int[] result = twoSum2(input, 9);
        System.out.println("\n result arr: ");
        printArr(result);
    }
    
}
