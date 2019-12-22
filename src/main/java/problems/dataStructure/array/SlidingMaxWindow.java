package problems.dataStructure.array;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

/**
 * 生成窗口最大值数组
 * 有一个整形数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置
 * 例如数组为【4,3,5,4,3,3,6,7】，窗口大小为3时，结果应返回{5,5,5,4,6,7}
 * 思路1：时间复杂度O(arr.len * window)
 * 思路2：时间复杂度o(arr.len)
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

    返回滑动窗口中的最大值。
    
    示例:
    
    输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    输出: [3,3,5,5,6,7] 
    解释: 
    
      滑动窗口的位置                最大值
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
     
    
    提示：
    
    你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
    
     
    
    进阶：
    
    你能在线性时间复杂度内解决此题吗？
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/sliding-window-maximum
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: SlidingMaxWindow.java, v 0.1 2019年8月20日 下午6:22:16 prd-fuy Exp $
 */
public class SlidingMaxWindow {
    private int[] array;
    private int   window;

    public SlidingMaxWindow() {

    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setWindow(int window) {
        this.window = window;
    }

    public int[] getMaxValueArray() {
        if (array.length < window)
            throw new RuntimeException("value of window cannot be bigger than array.length");
        int[] output = new int[array.length - window + 1];
        for (int i = 0; i <= array.length - window; i++) {
            int max = 0;
            for (int j = i; j < window + i; j++) {
                if (array[j] > max)
                    max = array[j];
            }
            output[i] = max;
        }
        return output;
    }

    /**
     * <b>时间复杂度O(arr.length)的方法，构造双端队列，存储数组下标</b>
     * <p>开始遍历数组：</p>
     * <p>入队时，若当前队列为空，直接入队</p>
     * <p>若不为空，则判断当前值与队尾大小，若当前值小则直接入队尾，否则弹出队尾，并继续下一轮判断</p>
     * <p>出队时，若队头下标在窗口外，则弹出队头</p>
     * <p>以当前队头为输出最大值数组</p>
     * @return
     */
    public int[] getMaxValueArray2() {
        if (array.length < window)
            throw new RuntimeException("value of window cannot be bigger than array.length");
        if (window == 1)
            return this.array;
        int[] output = new int[array.length - window + 1];
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && array[i] >= array[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(i);
            if (deque.peekFirst() == i - window)
                deque.pollFirst();
            if (i + 1 >= window)
                output[i - window + 1] = array[deque.peekFirst()];
        }
        return output;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < 1)
            return null;
        return null;
    }

    @Test
    public void test1() {
        int[] array = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int window = 3;
        SlidingMaxWindow slidingMaxWindow = new SlidingMaxWindow();
        slidingMaxWindow.setArray(array);
        slidingMaxWindow.setWindow(window);
        //        int[] output = slidingMaxWindow.getMaxValueArray();
        //        for (int i = 0; i < output.length; i++) {
        //            System.out.println("output [" + i + "] : " + output[i]);
        //        }
        int[] output2 = slidingMaxWindow.getMaxValueArray2();
        for (int i = 0; i < output2.length; i++) {
            System.out.println("output [" + i + "] : " + output2[i]);
        }
    }
}
