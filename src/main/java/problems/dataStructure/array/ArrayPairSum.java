package problems.dataStructure.array;

import org.junit.Test;

import problems.algorithm.QuickSort;

/**
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。

    示例 1:
    
    输入: [1,4,3,2]
    
    输出: 4
    解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
    提示:
    
    n 是正整数,范围在 [1, 10000].
    数组中的元素范围在 [-10000, 10000].
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/array-partition-i
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: ArrayPairSum.java, v 0.1 2019年11月1日 上午10:26:32 prd-fuy Exp $
 */
public class ArrayPairSum {
    
    public int arrayPairSum(int[] nums) {
        QuickSort qSort = new QuickSort();
        int[] arr = qSort.quickSort(nums, 0, nums.length - 1);
        int sum = 0;
        for (int i = 0; i < arr.length; i += 2) {
            sum += arr[i];
        }
        return sum;
    }
    
    @Test
    public void test1() {
        int[] arr = { 1, 4, 3, 2 };
        System.out.println("sum = " + arrayPairSum(arr));
    }
}
