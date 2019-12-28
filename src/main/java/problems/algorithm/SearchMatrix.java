package problems.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
    Example 1:
    
    Input:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 3
    Output: true
    Example 2:
    
    Input:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 13
    Output: false
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/search-a-2d-matrix
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: SearchMatrix.java, v 0.1 2019年12月27日 下午11:16:22 anfeel Exp $
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1)
            return false;
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                i--;
            else if (matrix[i][j] < target)
                j++;
        }
        return false;
    }

    @Test
    public void test1() {
        int[][] matrix = { { 1, 3, 6, 8, 14, 47 }, { 2, 9, 18, 24, 25, 48 }, { 4, 11, 19, 29, 30, 61 }, { 5, 12, 20, 38, 39, 66 }, { 7, 13, 45, 46, 60, 70 } };
        Assert.assertTrue(searchMatrix(matrix, 47));
    }

    @Test
    public void test2() {
        int[][] matrix = { { 1, 3, 6, 8, 14, 47 }, { 2, 9, 18, 24, 25, 48 }, { 4, 11, 19, 29, 30, 61 }, { 5, 12, 20, 38, 39, 66 }, { 7, 13, 45, 46, 60, 70 } };
        Assert.assertFalse(searchMatrix(matrix, 23));
    }

    @Test
    public void test3() {
        int[][] matrix = { { 1, 3, 6, 8, 14, 47 }, { 2, 9, 18, 24, 25, 48 }, { 4, 11, 19, 29, 30, 61 }, { 5, 12, 20, 38, 39, 66 }, { 7, 13, 45, 46, 60, 70 } };
        Assert.assertFalse(searchMatrix(matrix, 0));
    }

    @Test
    public void test4() {
        int[][] matrix = { { 1, 3, 6, 8, 14, 47 }, { 2, 9, 18, 24, 25, 48 }, { 4, 11, 19, 29, 30, 61 }, { 5, 12, 20, 38, 39, 66 }, { 7, 13, 45, 46, 60, 70 } };
        Assert.assertFalse(searchMatrix(matrix, 112));
    }

    @Test
    public void test5() {
        int[][] matrix = { { 1, 3, 6, 8, 14, 47 }, { 2, 9, 18, 24, 25, 48 }, { 4, 11, 19, 29, 30, 61 }, { 5, 12, 20, 38, 39, 66 }, { 7, 13, 45, 46, 60, 70 } };
        Assert.assertTrue(searchMatrix(matrix, 3));
    }

    @Test
    public void test6() {
        int[][] matrix = {};
        Assert.assertFalse(searchMatrix(matrix, 3));
    }
}
