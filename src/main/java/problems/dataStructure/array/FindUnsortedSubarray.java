package problems.dataStructure.array;

import org.junit.Test;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:FindUnsortedSubarray, v 0.1 2020年09月09日 9:24 anfeel Exp $
 */
public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int minIndex = -1;
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i > -1; i--) {
            if (nums[i] > min)
                minIndex = i;
            else
                min = Math.min(min, nums[i]);

        }
        if (minIndex == -1)
            return 0;
        int maxIndex = -1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max)
                maxIndex = i;
            else
                max = Math.max(max, nums[i]);
        }
        return maxIndex - minIndex + 1;
    }

    @Test
    public void test1() {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    @Test
    public void test2() {
        System.out.println(findUnsortedSubarray(new int[]{1, 5, 3, 4, 2, 6, 7}));
    }

    @Test
    public void test3() {
        System.out.println(findUnsortedSubarray(new int[]{1}));
    }

    @Test
    public void test4() {
        System.out.println(findUnsortedSubarray(new int[]{}));
    }

    @Test
    public void test5() {
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 3, 3}));
    }
}
