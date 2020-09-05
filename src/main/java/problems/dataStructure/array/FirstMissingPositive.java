package problems.dataStructure.array;

import org.junit.Test;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:FirstMissingPositive, v 0.1 2020年09月04日 10:41 anfeel Exp $
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        //记录数组中最小的正整数
        int min = nums[0];
        //记录数组中最小的正整数
//        int max = nums[0];
        //统计数组中正整数的个数
        int count = 0;
        //计算数组中所有正整数的相加和
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (nums[i] < min)
                    min = nums[i];
//                if (nums[i] > max)
//                    max = nums[i];
                count++;
            }

        }
        if (min > 1)
            return 1;

        boolean[] seq = new boolean[count + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] - 1 < seq.length) {
                seq[nums[i] - 1] = true;
            }
        }
        for (int i = 0; i < seq.length; i++) {
            if (!seq[i])
                return i + 1;
        }
        return 0;
    }


    @Test

    public void test1() {
        int[] arr = new int[]{7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(arr));
    }

    @Test
    public void test2() {
        int[] arr = new int[]{3, 4, -1, 1};
        System.out.println(firstMissingPositive(arr));
    }

    @Test
    public void test3() {
        int[] arr = new int[]{1, 2, 0};
        System.out.println(firstMissingPositive(arr));
    }

    @Test
    public void test4() {
        int[] arr = new int[]{1, 3, 5};
        System.out.println(firstMissingPositive(arr));
    }

    @Test
    public void test5() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 14, 16, 19};
        System.out.println(firstMissingPositive(arr));
    }

    @Test
    public void test6() {
        int[] arr = new int[]{0};
        System.out.println(firstMissingPositive(arr));
    }
}
