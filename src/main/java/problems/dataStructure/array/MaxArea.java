package problems.dataStructure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given n non-negative integers a1, a2, ..., an , 
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container and n is at least 2.
    
    The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
    In this case, the max area of water (blue section) the container can contain is 49.

    Example1:
    
    Input: [1,8,6,2,5,4,8,3,7]
    Output: 49
    
    Example2:
    
    Input: [1,4,3,2,5,4,8,3,7,1,2,1,3,4]
    Output: 52
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/container-with-most-water
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 
 * @author anfeel
 * @version $Id: MaxArea.java, v 0.1 2019年12月21日 下午8:21:02 anfeel Exp $
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int len = height.length;
        if (len == 1)
            return height[0];
        int maxArea = 0, i = 0, j = len - 1;
        while (i <= j) {
            int area = 0;
            if (height[j] > height[i]) {
                area = height[i] * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
                i++;
            } else {
                area = height[j] * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
                j--;
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        int len = height.length;
        if (len == 1)
            return height[0];
        int maxArea = 0, maxI = 0, maxJ = len - 1;
        for (int i = 0; i < len; i++) {
            int j = len - i - 1;
            int curArea = 0;
            int na1 = 0, na2 = 0;
            if (height[i] > height[maxI] && i != maxJ) {
                na1 = (height[i] > height[maxJ] ? height[maxJ] : height[i]) * (maxJ > i ? (maxJ - i) : (i - maxJ));
            }
            if (height[j] > height[maxJ] && j != maxI) {
                na2 = (height[j] > height[maxI] ? height[maxI] : height[j]) * (j > maxI ? (j - maxI) : (maxI - j));
            }
            curArea = (height[j] > height[i] ? height[i] : height[j]) * (j > i ? (j - i) : (i - j));
            if (na1 > na2 && na1 > maxArea) {
                maxArea = na1;
                maxI = i;
            } else if (na2 > na1 && na2 > maxArea) {
                maxArea = na2;
                maxJ = j;
            } else {
                if (curArea > maxArea) {
                    maxArea = curArea;
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        return maxArea;
    }

    @Test
    public void test1() {
        Assert.assertEquals(49, maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(49, maxArea(new int[] { 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(48, maxArea(new int[] { 1, 4, 3, 2, 5, 4, 8, 3, 7, 1, 2, 1, 3, 4 }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(3, maxArea(new int[] { 3 }));
    }

    @Test
    public void test5() {
        Assert.assertEquals(21, maxArea(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 21, 21, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
    }

    @Test
    public void test6() {
        Assert.assertEquals(19, maxArea(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 19, 19, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
    }

    @Test
    public void test7() {
        Assert.assertEquals(19, maxArea(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 18, 17, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
    }

    @Test
    public void test8() {
        Assert.assertEquals(20, maxArea(new int[] { 1, 2, 4, 6, 8, 8, 6, 4, 2, 1 }));
    }

    @Test
    public void test9() {
        Assert.assertEquals(0, maxArea(new int[] {}));
    }

    @Test
    public void testa() {
        Assert.assertEquals(17, maxArea(new int[] { 2, 3, 4, 5, 18, 17, 6 }));
    }

    @Test
    public void testb() {
        Assert.assertEquals(54, maxArea(new int[] { 1, 2, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 18, 17, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 2, 1 }));
    }

}
