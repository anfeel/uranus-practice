package problems.dataStructure.array;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    
    示例 1:
    
    输入: [3,2,3]
    输出: 3
    示例 2:
    
    输入: [2,2,1,1,1,2,2]
    输出: 2
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/majority-element
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: MajorityElement.java, v 0.1 2019年12月10日 下午6:45:35 anfeel Exp $
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i]) + 1);
            if (map.get(nums[i]) > nums.length / 2)
                return nums[i];
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {

        return 0;
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, majorityElement(new int[] { 3, 2, 3 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, majorityElement(new int[] { 1 }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(4, majorityElement(new int[] { 3, 3, 3, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4 }));
    }
}
