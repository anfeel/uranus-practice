package problems.algorithm.sort;

import org.junit.Test;

/**
 * 冒泡排序
 * @author anfeel
 * @version $ Id:BubbleSort, v 0.1 2020年07月16日 16:10 anfeel Exp $
 */
public class BubbleSort {
    @Test
    public void test1() {
        int[] arr = {3, 1, 8, 0, 4, 6, 9, 5, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d ", arr[i]);
        }
        System.out.println();
        bubble(arr);
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
        bubble(arr);
        System.out.println("after sorting :" + System.currentTimeMillis());
    }

    public void bubble(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    flag = true;
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            if (!flag)
                break;
            else
                flag = false;
        }
    }

}
