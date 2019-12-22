package problems.dataStructure.array;

import org.junit.Test;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

    示例 1:
    
    输入: [1,2,1]
    输出: [2,-1,2]
    解释: 第一个 1 的下一个更大的数是 2；
    数字 2 找不到下一个更大的数； 
    第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
    注意: 输入数组的长度不会超过 10000。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/next-greater-element-ii
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: NextGreaterElementAdv.java, v 0.1 2019年11月6日 下午2:38:45 prd-fuy Exp $
 */
public class NextGreaterElementAdv {
    public int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[nums.length];
        if (nums.length == 1)
            arr[0] = -1;
        for (int i = 0; i < arr.length; i++) {
            boolean round = false;
            for (int j = i + 1; j < nums.length + i; j++) {
                if (j == nums.length) {
                    j = 0;
                    round = true;
                }
                if (nums[j] > nums[i]) {
                    arr[i] = nums[j];
                    break;
                }
                if ((j == nums.length + i - 1 && !round) || (j == i - 1 && round)) {
                    arr[i] = -1;
                    break;
                }
                
            }
        }
        return arr;
    }
    
    @Test
    public void test1() {
        int[] res = nextGreaterElements(new int[] { 1, 2, 1 });
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
    
    @Test
    public void test2() {
        int[] res = nextGreaterElements(new int[] { 1, 2, 1, 3, 1, 4, 1, 5, 1, 6 });
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
    
    @Test
    public void test3() {
        int[] res = nextGreaterElements(new int[] { 1 });
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
    
    @Test
    public void test4() {
        int[] res = nextGreaterElements(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 });
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
    
    @Test
    public void test5() {
        int[] res = nextGreaterElements(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
    
    @Test
    public void test6() {
        int[] res = nextGreaterElements(new int[] { 1, 4, 1, 2, 5, 1, 4, 2, 1, 4 });
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
