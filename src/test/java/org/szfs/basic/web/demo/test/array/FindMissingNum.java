package org.szfs.basic.web.demo.test.array;

import java.util.Arrays;
import java.util.BitSet;

import org.junit.Test;

/**
 * 在一个1到100的整数数组中找到丢失的数字
 * 1.如果数组存在多个缺失的数字？
 * 2.查找数组重复项
 * @author prd-fuy
 * @version $Id: FindMissingNum.java, v 0.1 2019年9月5日 下午5:02:53 prd-fuy Exp $
 */
public class FindMissingNum {
    
    public int findMissingNum(int[] array) {
        int sum = 0, res = 0;
        for (int i : array) {
            sum += i;
        }
        res = (1 + 100) * 100 / 2;
        return res - sum;
    }
    
    public void findMutipleMissingNum(int[] array, int count) {
        int missingCount = count - array.length;
        BitSet bitSet = new BitSet();
        for (int i : array) {
            bitSet.set(i - 1);
        }
        System.out.println("array = " + Arrays.toString(array) + "  , count =   " + count);
        int lastIndex = 0;
        
        for (int i = 0; i < missingCount; i++) {
            lastIndex = bitSet.nextClearBit(lastIndex);
            System.out.println(++lastIndex);
        }
    }
    
    @Test
    public void test1() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
                      48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91,
                      92, 93, 94, 95, 96, 97, 98, 99, 100 };
        int num = findMissingNum(arr);
        System.out.println("missing num = " + num);
    }
    
    @Test
    public void test2() {
        findMutipleMissingNum(new int[] { 1, 2, 3, 5, 6, 8 }, 10);
        findMutipleMissingNum(new int[] { 3 }, 10);
        findMutipleMissingNum(new int[] { 1, 2, 3, 5, 6, 8, 9, 10 }, 10);
        findMutipleMissingNum(new int[] { 1, 2, 3, 5 }, 7);
    }
    
}
