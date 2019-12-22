package problems.dataStructure.array;

import org.junit.Test;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。

    将图像顺时针旋转 90 度。
    说明：
    你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
    
    示例 1:
    给定 matrix = 
    [
      [1,2,3],
      [4,5,6],
      [7,8,9]
    ],
    原地旋转输入矩阵，使其变为:
    [
      [7,4,1],
      [8,5,2],
      [9,6,3]
    ]
    示例 2:
    
    给定 matrix =
    [
      [ 5, 1, 9,11],
      [ 2, 4, 8,10],
      [13, 3, 6, 7],
      [15,14,12,16]
    ], 
    原地旋转输入矩阵，使其变为:
    [
      [15,13, 2, 5],
      [14, 3, 4, 1],
      [12, 6, 8, 9],
      [16, 7,10,11]
    ]
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/rotate-image
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: Rotate.java, v 0.1 2019年12月12日 下午7:45:43 anfeel Exp $
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int r = (row & 1) == 1 ? (row / 2) - 1 : (row - 1) / 2;
        int c = (col - 1) / 2;
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[col - j - 1][i];
                matrix[col - j - 1][i] = matrix[row - i - 1][col - j - 1];
                matrix[row - i - 1][col - j - 1] = matrix[j][row - i - 1];
                matrix[j][row - i - 1] = temp;
            }
        }

    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf(" %d ", matrix[i][j]);
            }
            System.out.println("");
        }
    }

    @Test
    public void test1() {
        int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);
    }

    @Test
    public void test2() {
        int[][] matrix = { { 1, 2, 3, 4 }, { 6, 7, 8, 9 }, { 11, 12, 13, 14 }, { 16, 17, 18, 19, } };
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);
    }

    @Test
    public void test3() {
        int[][] matrix = { {} };
        rotate(matrix);
    }
}
