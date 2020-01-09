package problems.dataStructure.bit;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
    Given two integers x and y, calculate the Hamming distance.
    
    Note:
    0 ≤ x, y < 231.
    
    Example:
    
    Input: x = 1, y = 4
    
    Output: 2
    
    Explanation:
    1   (0 0 0 1)
    4   (0 1 0 0)
           ↑   ↑
    
    The above arrows point to positions where the corresponding bits are different.
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/hamming-distance
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: HammingDistance.java, v 0.1 2019年12月9日 下午4:26:19 anfeel Exp $
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int d = 0;
        int z = x ^ y;
        int t = y > x ? y : x;
        while (t != 0) {
            if (((z ^ 1) & 1) == 0) {
                d++;
            }
            z = z >> 1;
            t = t >> 1;
        }
        return d;
    }

    @Test
    public void Test() {
        int z = 1 ^ 4;
        System.out.println(z);
    }

    @Test
    public void test1() {
        //1=0001 , 4=0100
        Assert.assertEquals(2, hammingDistance(1, 4));
    }

    @Test
    public void test2() {
        //3=0011,12=1100
        Assert.assertEquals(4, hammingDistance(3, 12));
    }

    @Test
    public void test3() {
        //7=0111,8=1000
        Assert.assertEquals(4, hammingDistance(7, 8));
    }

    @Test
    public void test4() {
        //4=0100,8=1000
        Assert.assertEquals(2, hammingDistance(4, 8));
    }

    @Test
    public void test5() {
        //0=0000,0=0000
        Assert.assertEquals(0, hammingDistance(0, 0));
    }

    @Test
    public void test6() {
        //11=1011,1=1101
        Assert.assertEquals(2, hammingDistance(11, 13));
    }

    @Test
    public void test7() {
        //0=0000,1=0001
        Assert.assertEquals(1, hammingDistance(0, 1));
    }
}
