package dataStructure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    
    示例:
    
    输入: [-2,1,-3,4,-1,2,1,-5,4]
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 

    输入: [-2,1,-3,4,-1,2,1,-4,5]
    输出: 7
    
    输入: [5,4,3,2,1,-1,-2,-3,-4,-5]
    输出: 15
    
    输入: [5,-5,4,-4,3,-3,2,-2,1,-1,6]
    输出: 6 
    
    输入: [5,-6,4,-5,3,-4,2,-3,1,-2,6]
    输出: 6 
    
    输入: [-1,-2,-1,-3,-1,-2,-4]
    输出: -1 
    
    输入: [-1,1,-1,-3,-1,-2,-4]
    输出: 1
     
    进阶:
    如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/maximum-subarray
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: MaxSubArray.java, v 0.1 2019年12月6日 下午3:13:39 anfeel Exp $
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length < 1)
            return 0;
        int sum = 0, sumMax = 0;
        boolean b = true;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum = nums[i];
                sumMax = sum;
                continue;
            }
            if ((nums[i] > 0 && sum < 0) || (nums[i] > sum && !b)) {
                sum = nums[i];
                sumMax = sum;
            } else if ((nums[i] > 0 || (nums[i] < 0 && i + 1 < nums.length && nums[i + 1] + nums[i] > 0)) && b) {
                sum += nums[i];
                if (i == nums.length - 1 && sum > sumMax)
                    sumMax = sum;
            } else if (nums[i] < 0 && (nums[i] + sum < 0 || (i + 1 < nums.length && nums[i + 1] + nums[i] < 0)) && b) {
                b = false;
                if (sum > sumMax)
                    sumMax = sum;
            }
        }
        return sumMax;
    }

    @Test
    public void test1() {
        Assert.assertEquals(6, maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(7, maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -4, 5 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(15, maxSubArray(new int[] { 5, 4, 3, 2, 1, -1, -2, -3, -4, -5 }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(6, maxSubArray(new int[] { 5, -5, 4, -4, 3, -3, 2, -2, 1, -1, 6 }));
    }

    @Test
    public void test5() {
        Assert.assertEquals(6, maxSubArray(new int[] { 5, -6, 4, -5, 3, -4, 2, -3, 1, -2, 6 }));
    }

    @Test
    public void test6() {
        Assert.assertEquals(-1, maxSubArray(new int[] { -1, -2, -1, -3, -1, -2, -4 }));
    }

    @Test
    public void test7() {
        Assert.assertEquals(1, maxSubArray(new int[] { -1, 1, -1, -3, -1, -2, -4 }));
    }

    @Test
    public void test8() {
        Assert.assertEquals(1, maxSubArray(new int[] { -1, 1 }));
    }

    @Test
    public void test9() {
        Assert.assertEquals(-1, maxSubArray(new int[] { -1 }));
    }

    @Test
    public void testa() {
        Assert.assertEquals(0, maxSubArray(new int[] {}));
    }

    @Test
    public void testb() {
        Assert.assertEquals(6, maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4, -2 }));
    }
}
