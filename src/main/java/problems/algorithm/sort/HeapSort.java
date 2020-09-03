package problems.algorithm.sort;

import org.junit.Test;

/**
 * 堆排序
 * 大顶堆相当于升序排序
 * @author anfeel
 * @version $ Id:HeapSort, v 0.1 2020年09月01日 17:17 anfeel Exp $
 */
public class HeapSort {

    public void heapSort(int[] tree, int len) {
        buildHeap(tree, len);
        for (int i = len - 1; i >= 1; i--) {
            swap(tree, 0, i);
            buildHeap(tree, i);
        }
    }

    public void buildHeap(int[] tree, int len) {
        int last = len - 1;
        int parent = (last - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(tree, len, i);
        }
    }

    public void heapify(int[] tree, int len, int i) {
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        int max = i;
        if (c1 < len && tree[c1] > tree[max])
            max = c1;
        if (c2 < len && tree[c2] > tree[max])
            max = c2;
        if (max != i) {
            swap(tree, max, i);
            heapify(tree, len, max);
        }
    }

    public void swap(int[] tree, int i, int j) {
        int tmp = tree[i];
        tree[i] = tree[j];
        tree[j] = tmp;
    }

    @Test
    public void test1() {
        int[] tree = {4, 3, 5, 1, 2, 6, 7, 8, 9};
        int len = tree.length;
        heapSort(tree, len);
        for (int i = 0; i < len; i++) {
            System.out.printf("%d ", tree[i]);
        }
    }

    @Test
    public void test2() {
        int[] tree = {3, 2, 1};
        int len = tree.length;
        heapSort(tree, len);
        for (int i = 0; i < len; i++) {
            System.out.printf("%d ", tree[i]);
        }
    }


}
