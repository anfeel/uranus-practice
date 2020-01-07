package problems.dataStructure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them 
    is that adjacent houses have security system connected 
    and it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given a list of non-negative integers representing the amount of money of each house, 
    determine the maximum amount of money you can rob tonight without alerting the police.
    
    Example 1:
    
    Input: [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
                 Total amount you can rob = 1 + 3 = 4.
    Example 2:
    
    Input: [2,7,9,3,1]
    Output: 12
    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
                 Total amount you can rob = 2 + 9 + 1 = 12.
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/house-robber
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: Rob.java, v 0.1 2020年1月7日 下午7:27:46 anfeel Exp $
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        return Math.max(Math.max(sum(nums, 2, nums[0]), sum(nums, 3, nums[0])), Math.max(sum(nums, 3, nums[1]), sum(nums, 4, nums[1])));
    }

    public int sum(int[] nums, int start, int sum) {
        if (start > nums.length - 1)
            return sum;
        return Math.max(sum + sum(nums, start + 2, nums[start]), sum + sum(nums, start + 3, nums[start]));
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, rob(new int[] { 1, 2, 3, 1 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(12, rob(new int[] { 2, 7, 9, 3, 1 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, rob(new int[] { 3 }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(4, rob(new int[] { 1, 4 }));
    }

    @Test
    public void test5() {
        Assert.assertEquals(26, rob(new int[] { 2, 1, 1, 9, 1, 1, 8, 1, 1, 7 }));
    }

    @Test
    public void test6() {
        Assert.assertEquals(0, rob(new int[] {}));
    }

    @Test
    public void test7() {
        Assert.assertEquals(3, rob(new int[] { 1, 3, 1 }));
    }
}
