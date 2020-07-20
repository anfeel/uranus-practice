package problems.algorithm.sort;

import org.junit.Test;

/**
 * 选择排序
 * @author anfeel
 * @version $ Id:SelectSort, v 0.1 2020年07月17日 9:44 anfeel Exp $
 */
public class SelectSort {
    public void Select(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i], pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    pos = j;
                }
            }
            arr[pos] = arr[i];
            arr[i] = min;
        }
    }

    @Test
    public void test1() {
        int[] arr = {3, 1, 8, 0, 4, 6, 9, 5, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d ", arr[i]);
        }
        System.out.println();
        Select(arr);
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
        Select(arr);
        System.out.println("after sorting :" + System.currentTimeMillis());
    }
}
