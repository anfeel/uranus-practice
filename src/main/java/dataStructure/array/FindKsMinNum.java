package dataStructure.array;

import org.junit.Test;

/**
 * 找到无序数组中最小的k个数
 * 给定一个无序的整型数组arr，找到其中最小的k个数
 * 排序自然可以得到最小的k个数，此时间复杂度为O(NlogN)
 * 要求得到时间复杂度O(Nlogk)和O(N)的解法
 * @author prd-fuy
 * @version $Id: FindKsMinNum.java, v 0.1 2019年9月6日 下午2:54:30 prd-fuy Exp $
 */
public class FindKsMinNum {
    
    public int[] findKsMinNum1(int[] arr, int k) {
        if (k < 1 || k > arr.length)
            return arr;
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(kHeap, arr[i], i);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }
    
    public void heapInsert(int[] kHeap, int value, int index) {
        kHeap[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (kHeap[parent] > kHeap[index]) {
                int tmp = kHeap[parent];
                kHeap[parent] = kHeap[index];
                kHeap[index] = tmp;
                index = parent;
            } else
                break;
        }
    }
    
    public void heapify(int[] kHeap, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (kHeap[left] > kHeap[index]) {
                largest = left;
            }
            if (right < heapSize && kHeap[right] > kHeap[largest]) {
                largest = right;
            }
            if (largest != index) {
                int tmp = kHeap[largest];
                kHeap[largest] = kHeap[index];
                kHeap[index] = tmp;
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }
    
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %s ", arr[i]);
        }
    }
    
    @Test
    public void test1() {
        int[] array = { 3, 5, 6, 7, 8, 2, 4, 6, 5, 8, 1, 4, 8, 7, 12, 5, 8, 13, 7 };
        int[] result = findKsMinNum1(array, 6);
        printArray(result);
    }
    
}
