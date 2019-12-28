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
 * @version $Id: SearchMatrixAdv.java, v 0.1 2019年12月28日 下午9:17:36 anfeel Exp $
 */
public class SearchMatrixAdv {
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
        int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
        Assert.assertTrue(searchMatrix(matrix, 5));
    }

    @Test
    public void test2() {
        int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
        Assert.assertFalse(searchMatrix(matrix, 20));
    }

    @Test
    public void test3() {
        int[][] matrix = {};
        Assert.assertFalse(searchMatrix(matrix, 3));
    }
}
