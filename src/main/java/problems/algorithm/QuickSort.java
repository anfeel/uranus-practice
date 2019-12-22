package problems.algorithm;

import org.junit.Test;

/**
 * 快速排序
 * @author anfeel
 * @version $Id: QuickSort.java, v 0.1 2019年9月21日 下午1:29:25 anfeel Exp $
 */
public class QuickSort {
    
    public int[] quickSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && arr[j] > pivot)
                j--;
            while (i < j && arr[i] < pivot)
                i++;
            if (arr[i] == arr[j] && i < j)
                i++;
            else {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        if (i - 1 > start)
            quickSort(arr, start, i - 1);
        if (j + 1 < end)
            quickSort(arr, j + 1, end);
        return arr;
    }
    
    @Test
    public void test1() {
        int[] arr = { 72, 1, 23, 48, 46, 88, 39, 4, 78, 88, 12 };
        int[] res = quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < res.length; i++) {
            System.out.printf(" %d ", res[i]);
        }
    }
}
