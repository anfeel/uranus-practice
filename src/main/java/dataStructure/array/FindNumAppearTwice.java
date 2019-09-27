package dataStructure.array;

import org.junit.Test;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度O(1)
 * 1.先思考这个数组只有一个数字出现一次，其他的都出现两次的情况
 * @author anfeel
 * @version $Id: FindNumAppearTwice.java, v 0.1 2019年9月20日 下午11:47:17 anfeel Exp $
 */
public class FindNumAppearTwice {

    public void findingNumApperOnce(int[] arr) {
        if (arr.length < 1)
            return;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        System.out.println(" result = " + res);
    }

    public void findingNumApperTwice(int[] arr) {
        if (arr.length < 2)
            return;
        int res = 0;
        int res1 = 0, res2 = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        int indexOf1 = findFirstBit1(res);

        for (int i : arr) {
            if (isBit1(i, indexOf1)) {
                res1 ^= i;
            } else {
                res2 ^= i;
            }
        }
        System.out.printf(" num1 = %d , num2 = %d ", res1, res2);
    }

    private static int findFirstBit1(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
            num >>>= 1;
            index++;
        }
        return index;
    }

    private static boolean isBit1(int num, int indexBit) {
        num >>>= indexBit;
        return (num & 1) == 1;
    }

    @Test
    public void test1() {
        findingNumApperOnce(new int[] { 1, 2, 2, 3, 3, 1, 4, 7, 5, 7, 8, 8, 4 });
    }

    @Test
    public void test2() {
        findingNumApperTwice(new int[] { 1, 2, 2, 3, 3, 1, 4, 7, 5, 7, 8, 8, 4, 6 });
    }

}
