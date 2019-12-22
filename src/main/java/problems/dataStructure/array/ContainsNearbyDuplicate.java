package problems.dataStructure.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

    示例 1:
    
    输入: nums = [1,2,3,1], k = 3
    输出: true
    示例 2:
    
    输入: nums = [1,0,1,1], k = 1
    输出: true
    示例 3:
    
    输入: nums = [1,2,3,1,2,3], k = 2
    输出: false
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/contains-duplicate-ii
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: ContainsNearbyDuplicate.java, v 0.1 2019年11月3日 下午3:28:35 anfeel Exp $
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 0)
            return false;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> distance = new ArrayList<Integer>();
                distance.add(i);
                map.put(nums[i], distance);
            } else {
                List<Integer> distance = map.get(nums[i]);
                distance.add(i);
                for (int j = 0; j < distance.size() - 1; j++) {
                    if (k >= distance.get(distance.size() - 1) - distance.get(j))
                        return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test1() {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsNearbyDuplicate(nums, 3));
    }

    @Test
    public void test2() {
        int[] nums = { 1, 0, 1, 1 };
        System.out.println(containsNearbyDuplicate(nums, 1));
    }

    @Test
    public void test3() {
        int[] nums = { 1, 2, 3, 1, 2, 3 };
        System.out.println(containsNearbyDuplicate(nums, 2));
    }

    @Test
    public void test4() {
        int[] nums = { 1 };
        System.out.println(containsNearbyDuplicate(nums, 2));
    }

    @Test
    public void test5() {
        int[] nums = {};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }

    @Test
    public void test6() {
        int[] nums = { 1, 2, 3, 3, 2, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3 };
        System.out.println(containsNearbyDuplicate(nums, 12));
    }

    @Test
    public void test7() {
        int[] nums = { 99, 99 };
        System.out.println(containsNearbyDuplicate(nums, 2));
    }

    @Test
    public void test8() {
        int[] nums = { 2, 2 };
        System.out.println(containsNearbyDuplicate(nums, 3));
    }
}
