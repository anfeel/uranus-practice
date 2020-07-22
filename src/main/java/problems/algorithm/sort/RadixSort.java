package problems.algorithm.sort;

import org.junit.Test;

/**
 * 桶排序
 * @author anfeel
 * @version $ Id:RadixSort, v 0.1 2020年07月22日 13:46 anfeel Exp $
 */
public class RadixSort {

    @Test
    public void test1() {
        int[] arr = {3, 1, 8, 0, 4, 6, 9, 5, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d ", arr[i]);
        }
        System.out.println();
        radixSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d ", arr[i]);
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        System.out.println("before sorting :" + System.currentTimeMillis());
        radixSort(arr);
        System.out.println("after sorting :" + System.currentTimeMillis());
    }

    public void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int len = (max + "").length();
        //构造桶，row为基数，col为当前基数下的数字
        int[][] bucket = new int[10][arr.length];
        //统计每个基数下有多少个数字
        int[] count = new int[10];
        //将各个元素的个位数放置到桶中
        for (int p = 0, n = 1; p < len; p++, n *= 10) {
            for (int i = 0; i < arr.length; i++) {
                //得到个位数
                int digit = arr[i] / n % 10;
                //将该数放入桶中，row即为个位数的位置，col为当前基数数字的统计值
                bucket[digit][count[digit]] = arr[i];
                //当前基数数字的统计值自增
                count[digit]++;
            }
            int index = 0;
            //将个位数排好序的数取出来并放回原数组
            for (int j = 0; j < bucket.length; j++) {
                if (count[j] > 0) {
                    for (int k = 0; k < count[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                count[j] = 0;
            }
        }
    }
}
