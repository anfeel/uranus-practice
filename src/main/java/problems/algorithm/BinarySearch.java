package problems.algorithm;

import org.junit.Test;

/**
 * 二分查找
 * @author prd-fuy
 * @version $Id: BinarySearch.java, v 0.1 2019年9月9日 下午4:20:09 prd-fuy Exp $
 */
public class BinarySearch {
    public int search(int[] arr, int value) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (value < arr[mid])
                hi = mid - 1;
            else if (value > arr[mid])
                lo = mid + 1;
            else
                return value;
        }
        return -1;
    }
    
    @Test
    public void test1() {
        int[] array = { 1, 2, 3, 4, 5, 7, 8, 9, 12, 13, 14, 24, 25, 26 };
        int rest = search(array, 7);
        if (rest > 0)
            System.out.printf("%d", rest);
    }
    
}
