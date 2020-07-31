package problems.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:SearchRange, v 0.1 2020年07月31日 8:41 anfeel Exp $
 */
public class SearchRange {

    @Test
    public void test1() {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    @Test
    public void test2() {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(arr, 6)));
    }

    @Test
    public void test3() {
        int[] arr = new int[]{2, 5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(arr, 6)));
    }

    @Test
    public void test4() {
        int[] arr = new int[]{2, 5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    @Test
    public void test5() {
        int[] arr = new int[]{8};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    @Test
    public void test6() {
        int[] arr = new int[]{8, 8};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    @Test
    public void test7() {
        int[] arr = new int[]{8, 8, 8, 8};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    @Test
    public void test8() {
        int[] arr = new int[]{};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }


    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[]{-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                int first = mid, last = mid;
                while (first >= 0 && nums[first] == target) {
                    first--;
                }
                first++;
                while (last < nums.length && nums[last] == target) {
                    last++;
                }
                last--;
                arr[0] = first;
                arr[1] = last;
                return arr;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return arr;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] arr = new int[]{-1, -1};
        int cur = nums.length / 2;
        while (cur > 1) {
            int t = nums[cur];
            if (t == target) {
                int begin = cur, end = cur;
                while (nums[begin] == target) {
                    begin--;
                }
                begin++;
                while (nums[end] == target) {
                    end++;
                }
                end--;
                arr[0] = begin;
                arr[1] = end;
                return arr;
            } else if (t > target) {
                cur = cur / 2;
            } else {
                cur = (cur + nums.length) / 2;
            }
        }
        return arr;
    }
}
