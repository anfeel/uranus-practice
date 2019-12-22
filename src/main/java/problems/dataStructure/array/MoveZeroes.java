package problems.dataStructure.array;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

    示例:
    
    输入: [0,1,0,3,12]
    输出: [1,3,12,0,0]
    说明:
    
    必须在原数组上操作，不能拷贝额外的数组。
    尽量减少操作次数。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/move-zeroes
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: MoveZeroes.java, v 0.1 2019年12月10日 下午7:15:22 anfeel Exp $
 */
public class MoveZeroes {
    //    输入: [0,1,0,3,12]
    //    输出: [1,3,12,0,0]
    public void moveZeroes(int[] nums) {
        Queue<Integer> posQ = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                posQ.offer(i);
            } else {
                if (posQ.size() > 0) {
                    int pos = posQ.poll();
                    int tmp = nums[pos];
                    nums[pos] = nums[i];
                    nums[i] = tmp;
                    posQ.offer(i);
                }
            }
        }
    }

    @Test
    public void test1() {
        int[] arr = new int[] { 0, 1, 0, 3, 12 };
        for (int j = 0; j < arr.length; j++) {
            System.out.printf(" %d ", arr[j]);
        }
        System.out.println();
        moveZeroes(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.printf(" %d ", arr[j]);
        }
    }

    @Test
    public void test2() {
        System.out.println();
        int[] arr = new int[] { 0, 0, 0, 0, 1, 2, 3 };
        for (int j = 0; j < arr.length; j++) {
            System.out.printf(" %d ", arr[j]);
        }
        System.out.println();
        moveZeroes(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.printf(" %d ", arr[j]);
        }
    }
}
