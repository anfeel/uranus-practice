package problems.algorithm.sort;

import org.junit.Test;

/**
 * 希尔排序
 * @author anfeel
 * @version $ Id:ShellSort, v 0.1 2020年07月21日 8:55 anfeel Exp $
 */
public class ShellSort {

    public void shell(int[] arr) {
        for (int gap = arr.length; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = 0;
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        tmp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = tmp;
                    }
                }
            }
        }
    }

    @Test
    public void test1() {
        int[] arr = {3, 1, 8, 0, 4, 6, 9, 5, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d ", arr[i]);
        }
        System.out.println();
        shell(arr);
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
        shell(arr);
        System.out.println("after sorting :" + System.currentTimeMillis());
    }
}
