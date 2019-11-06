package dataStructure.array;

import java.util.HashMap;

import org.junit.Test;

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
    
    nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
    
    示例 1:
    
    输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
    输出: [-1,3,-1]
    解释:
        对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
        对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
        对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
    示例 2:
    
    输入: nums1 = [2,4], nums2 = [1,2,3,4].
    输出: [3,-1]
    解释:
        对于num1中的数字2，第二个数组中的下一个较大数字是3。
        对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
    注意:
    
    nums1和nums2中所有元素是唯一的。
    nums1和nums2 的数组大小都不超过1000。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/next-greater-element-i
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: NextGreaterElement.java, v 0.1 2019年11月6日 上午10:04:29 prd-fuy Exp $
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], 1);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j]))
                map.put(nums2[j], j);
        }
        int[] arr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int k = map.get(nums1[i]);
            for (int j = k; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    arr[i] = nums2[j];
                    break;
                }
                if (j == nums2.length - 1 && arr[i] == 0)
                    arr[i] = -1;
            }
        }
        return arr;
    }
    
    @Test
    public void test1() {
        int[] res = nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 });
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
    
    @Test
    public void test2() {
        int[] res = nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 });
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
    
    @Test
    public void test3() {
        int[] res = nextGreaterElement(new int[] { 3 }, new int[] { 1, 3, 2, 4 });
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
    
    @Test
    public void test4() {
        int[] res = nextGreaterElement(new int[] { 1, 3, 2, 4 }, new int[] { 1, 3, 2, 4 });
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
