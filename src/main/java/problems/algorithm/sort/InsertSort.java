package problems.algorithm.sort;

import org.junit.Test;

/**
 * 插入排序
 * @author anfeel
 * @version $ Id:InsertSort, v 0.1 2020年07月17日 10:58 anfeel Exp $
 */
public class InsertSort {
    public void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //优化点：如果待插入位置与原始位置相同，不执行插入
            if (insertIndex + 1 != i)
                arr[insertIndex + 1] = insertVal;
        }
    }

    @Test
    public void test1() {
        int[] arr = {3, 1, 8, 0, 4, 6, 9, 5, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d ", arr[i]);
        }
        System.out.println();
        insert(arr);
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
        insert(arr);
        System.out.println("after sorting :" + System.currentTimeMillis());
    }
}