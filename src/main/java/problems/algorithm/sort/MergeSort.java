package problems.algorithm.sort;

import org.junit.Test;

/**
 * 归并排序
 * @author anfeel
 * @version $ Id:MergeSort, v 0.1 2020年07月21日 15:40 anfeel Exp $
 */
public class MergeSort {

    @Test
    public void test1() {
        int[] arr = {3, 1, 8, 0, 4, 6, 9, 5, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d ", arr[i]);
        }
        System.out.println();
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
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
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println("after sorting :" + System.currentTimeMillis());
    }

    public void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, tmp);
            mergeSort(arr, mid + 1, right, tmp);
            merge(arr, left, mid, right, tmp);
        }
    }

    public void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            tmp[t++] = arr[i++];
        }
        while (j <= right) {
            tmp[t++] = arr[j++];
        }

        t = 0;
        int p = left;
        while (p <= right) {
            arr[p] = tmp[t];
            t++;
            p++;
        }
    }
}
