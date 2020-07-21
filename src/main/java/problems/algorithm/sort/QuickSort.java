package problems.algorithm.sort;

import org.junit.Test;

/**
 * 快速排序
 * @author anfeel
 * @version $ Id:QuickSort, v 0.1 2020年07月21日 11:45 anfeel Exp $
 */
public class QuickSort {

    public void quick(int[] arr, int begin, int end) {
        int p = (begin + end) / 2;
        int i = begin;
        int j = end;
        while (i < j) {
            if (i < j && arr[i] < arr[p])
                i++;
            if (i < j && arr[j] > arr[p])
                j--;
            if (arr[i] == arr[j] && i < j)
                i++;
            else {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
//            while (arr[i] < arr[p])
//                i++;
//            while (arr[j] > arr[p])
//                j--;
//            if (i >= j)
//                break;
//            else {
//                int tmp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = tmp;
//            }
//            if (arr[i] == arr[p])
//                j--;
//            if (arr[j] == arr[p])
//                i++;
        }
        if (i - 1 > begin)
            quick(arr, begin, i - 1);
        if (j + 1 < end)
            quick(arr, j + 1, end);
    }

    @Test
    public void test1() {
        int[] arr = {3, 1, 8, 0, 4, 6, 9, 5, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d ", arr[i]);
        }
        System.out.println();
        quick(arr, 0, arr.length - 1);
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
        quick(arr, 0, arr.length - 1);
        System.out.println("after sorting :" + System.currentTimeMillis());
    }
}


