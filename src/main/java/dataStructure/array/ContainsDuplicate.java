package dataStructure.array;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 给定一个整数数组，判断是否存在重复元素。

    如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
    
    示例 1:
    
    输入: [1,2,3,1]
    输出: true
    示例 2:
    
    输入: [1,2,3,4]
    输出: false
    示例 3:
    
    输入: [1,1,1,3,3,4,3,2,4,2]
    输出: true
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/contains-duplicate
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: ContainsDuplicate.java, v 0.1 2019年11月3日 下午3:19:47 anfeel Exp $
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test1() {
        int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println(containsDuplicate(nums));
    }

    @Test
    public void test2() {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(containsDuplicate(nums));
    }

    @Test
    public void test3() {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }
}
