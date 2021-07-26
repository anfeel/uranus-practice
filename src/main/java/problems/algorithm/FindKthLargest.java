package problems.algorithm;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *  
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:FindKthLargest, v 0.1 2021年07月26日 10:24 anfeel Exp $
 */
public class FindKthLargest {

    public int findKthLargest(int nums[], int k) {
        if (nums == null || nums.length == 0 || k < 0 || k > nums.length)
            return 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (deque.size() != 0) {
                int cur = nums[i];
                if (cur > deque.peekFirst()) {
                    deque.addFirst(cur);
                } else if (cur < deque.peekLast()) {
                    deque.addLast(cur);
                } else {
                    Stack<Integer> stack = new Stack<>();
                    stack.push(deque.pollFirst());
                    while (!deque.isEmpty() && cur < deque.peekFirst()) {
                        stack.push(deque.pollFirst());
                    }
                    deque.addFirst(cur);
                    while (!stack.isEmpty()) {
                        deque.addFirst(stack.pop());
                    }
                }
            } else
                deque.addFirst(nums[i]);
        }
        int res = 0;
        for (int i = 1; i <= k; i++) {
            res = deque.pollFirst();
        }
        return res;
    }

    @Test
    public void test1() {
        int[] arr = new int[]{2, 6, 5, 9, 1};
        System.out.println(findKthLargest(arr, 3));
    }

    @Test
    public void test2() {
        int[] arr = new int[]{2, 6, 5, 9, 1};
        System.out.println(findKthLargest(arr, 2));
    }

    @Test
    public void test3() {
        int[] arr = new int[]{2, 6, 5, 9, 1};
        System.out.println(findKthLargest(arr, 1));
    }

    @Test
    public void test4() {
        int[] arr = new int[]{2, 6, 5, 9, 1};
        System.out.println(findKthLargest(arr, 4));
    }

    @Test
    public void test5() {
        int[] arr = new int[]{2, 6, 5, 9, 1};
        System.out.println(findKthLargest(arr, 5));
    }

    @Test
    public void test6() {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));
    }


    @Test
    public void test7() {
        int[] arr = new int[]{99, 99};
        System.out.println(findKthLargest(arr, 1));
    }

    @Test
    public void testArrayEmpty() {
        int[] arr = new int[]{};
        System.out.println(findKthLargest(arr, 5));
    }

    @Test
    public void testArrayNull() {
        int[] arr = null;
        System.out.println(findKthLargest(arr, 5));
    }

    @Test
    public void testKIlleagl() {
        int[] arr = new int[]{1, 2};
        System.out.println(findKthLargest(arr, -1));
    }


}
