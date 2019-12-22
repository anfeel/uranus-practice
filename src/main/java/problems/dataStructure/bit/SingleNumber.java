package problems.dataStructure.bit;

import org.junit.Test;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

    说明：
    
    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    
    示例 1:
    
    输入: [2,2,1]
    输出: 1
    示例 2:
    
    输入: [4,1,2,1,2]
    输出: 4
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/single-number
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: SingleNumber.java, v 0.1 2019年12月6日 下午3:06:41 anfeel Exp $
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a = a ^ nums[i];
        }
        return a;
    }

    @Test
    public void test1() {
        System.out.println(singleNumber(new int[] { 2, 2, 1 }));
    }

    @Test
    public void test2() {
        System.out.println(singleNumber(new int[] { 2, 2, 3, 3, 1, 4, 5, 6, 4, 6, 1 }));
    }

}
