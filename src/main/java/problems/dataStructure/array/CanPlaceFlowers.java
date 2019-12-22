package problems.dataStructure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

    给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
    
    示例 1:
    
    输入: flowerbed = [1,0,0,0,1], n = 1
    输出: True
    示例 2:
    
    输入: flowerbed = [1,0,0,0,1], n = 2
    输出: False
    注意:
    
    数组内已种好的花不会违反种植规则。
    输入的数组长度范围为 [1, 20000]。
    n 是非负整数，且不会超过输入数组的大小。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/can-place-flowers
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: CanPlaceFlowers.java, v 0.1 2019年11月3日 下午9:03:44 anfeel Exp $
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        boolean canPlace = true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (canPlace) {
                    if (i + 1 == flowerbed.length || (i + 1 < flowerbed.length && flowerbed[i + 1] == 0)) {
                        n--;
                        i++;
                        if (n == 0)
                            return true;
                    } else if (i + 1 < flowerbed.length && flowerbed[i + 1] == 1) {
                        i++;
                        canPlace = false;
                    }

                } else
                    canPlace = true;
            } else
                canPlace = false;
        }
        return false;
    }

    @Test
    public void test1() {
        int[] flowerbed = { 1, 0, 0, 0, 1 };
        Assert.assertTrue(canPlaceFlowers(flowerbed, 1));
    }

    @Test
    public void test2() {
        int[] flowerbed = { 1, 0, 0, 0, 1 };
        Assert.assertFalse(canPlaceFlowers(flowerbed, 2));
    }

    @Test
    public void test3() {
        int[] flowerbed = { 1 };
        Assert.assertFalse(canPlaceFlowers(flowerbed, 1));
    }

    @Test
    public void test4() {
        int[] flowerbed = { 0 };
        Assert.assertTrue(canPlaceFlowers(flowerbed, 1));
    }

    @Test
    public void test5() {
        int[] flowerbed = { 1, 0 };
        Assert.assertFalse(canPlaceFlowers(flowerbed, 1));
    }

    @Test
    public void test6() {
        int[] flowerbed = { 0, 0, 0 };
        Assert.assertTrue(canPlaceFlowers(flowerbed, 1));
    }

    @Test
    public void test7() {
        int[] flowerbed = { 0, 0, 0 };
        Assert.assertTrue(canPlaceFlowers(flowerbed, 2));
    }

    @Test
    public void test8() {
        int[] flowerbed = { 0, 1, 0 };
        Assert.assertFalse(canPlaceFlowers(flowerbed, 2));
    }

    @Test
    public void test9() {
        int[] flowerbed = { 0, 1 };
        Assert.assertFalse(canPlaceFlowers(flowerbed, 1));
    }

    @Test
    public void testa() {
        int[] flowerbed = { 1, 0, 0, 0, 0, 1 };
        Assert.assertFalse(canPlaceFlowers(flowerbed, 2));
    }

    @Test
    public void testb() {
        int[] flowerbed = { 1, 0, 1, 0, 1, 0, 1 };
        Assert.assertTrue(canPlaceFlowers(flowerbed, 0));
    }

    @Test
    public void testc() {
        int[] flowerbed = { 1 };
        Assert.assertTrue(canPlaceFlowers(flowerbed, 0));
    }

    @Test
    public void testd() {
        int[] flowerbed = { 0, 1, 0 };
        Assert.assertFalse(canPlaceFlowers(flowerbed, 1));
    }
}
