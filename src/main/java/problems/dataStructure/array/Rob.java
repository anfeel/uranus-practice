package problems.dataStructure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them
 * is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $Id: Rob.java, v 0.1 2020年1月7日 下午7:27:46 anfeel Exp $
 */
public class Rob {
    public int rob2(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        return Math.max(Math.max(sum2(nums, 2, nums[0]), sum2(nums, 3, nums[0])), Math.max(sum2(nums, 3, nums[1]), sum2(nums, 4, nums[1])));
    }

    public int sum2(int[] nums, int start, int sum) {
        if (start > nums.length - 1)
            return sum;
        return Math.max(sum + sum2(nums, start + 2, nums[start]), sum + sum2(nums, start + 3, nums[start]));
    }

    public int rob(int[] nums) {
        if (nums.length < 1)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int last = nums[0], pre = Math.max(nums[0], nums[1]), sum = pre;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] + last > pre)
                sum = nums[i] + last;
            last = pre;
            pre = sum;
        }
        return sum;
    }


    @Test
    public void test1() {
        Assert.assertEquals(4, rob(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(12, rob(new int[]{2, 7, 9, 3, 1}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, rob(new int[]{3}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(4, rob(new int[]{1, 4}));
    }

    @Test
    public void test5() {
        Assert.assertEquals(26, rob(new int[]{2, 1, 1, 9, 1, 1, 8, 1, 1, 7}));
    }

    @Test
    public void test6() {
        Assert.assertEquals(0, rob(new int[]{}));
    }

    @Test
    public void test7() {
        Assert.assertEquals(3, rob(new int[]{1, 3, 1}));
    }

    @Test
    public void test8() {
        Assert.assertEquals(17, rob(new int[]{4, 1, 3, 2, 4, 9, 6}));
    }

    @Test
    public void test9() {
        Assert.assertEquals(18, rob(new int[]{4, 1, 3, 2, 4, 9, 6, 2}));
    }

    @Test
    public void testa() {
        Assert.assertEquals(19, rob(new int[]{4, 1, 3, 2, 5, 9, 7, 2}));
    }

    @Test
    public void testb() {
        Assert.assertEquals(20, rob(new int[]{4, 1, 3, 5, 5, 9, 7, 2}));
    }

    @Test
    public void testc() {
        System.out.println(rob(new int[]{226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191, 68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72,
                80, 143, 55, 209, 18, 55, 122, 65, 66, 177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192, 125, 77, 223, 188, 99, 228, 90, 25, 193,
                211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10, 82, 35, 120, 180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124}));
    }

    @Test
    public void testd() {
        Assert.assertEquals(0, rob(new int[]{}));
    }

    @Test
    public void teste() {
        Assert.assertEquals(3, rob(new int[]{3}));
    }

    @Test
    public void testf() {
        Assert.assertEquals(4, rob(new int[]{3, 4}));
    }
}
