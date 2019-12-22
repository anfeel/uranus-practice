package problems.dataStructure.array;

import org.junit.Test;

/**
 * 将正方形矩阵顺时针转动90度
 * 例如：
 *  1    2   3   4
 *  5    6   7   8
 *  9  10 11 12
 * 13 14 15 16
 * 顺时针转动后：
 * 13   9   5   1
 * 14 10   6   7
 * 15 11   7   3
 * 16 12   8   4
 * 空间复杂度不做要求，直接转置
 * 空间复杂度O(1)
 * @author prd-fuy
 * @version $Id: MatrixTransform.java, v 0.1 2019年9月5日 下午8:07:36 prd-fuy Exp $
 */
public class MatrixTransform {
    
    public int[][] matrixTransform(int[][] matrix) {
        int sideLen = matrix.length;
        int[][] result = new int[sideLen][sideLen];
        for (int i = 0; i < sideLen; i++) {
            for (int j = 0; j < sideLen; j++) {
                result[i][j] = matrix[sideLen - 1 - j][i];
            }
        }
        return result;
    }
    
    public int[][] matrixTransformWithMinStore(int[][] matrix) {
        int sideLen = matrix.length;
        int tmp = 0;
        for (int i = 0; i < sideLen; i++) {
            for (int j = 0; j < sideLen; j++) {
            }
        }
        return matrix;
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
        int[][] result = matrixTransform(matrix);
        printMatrix(result);
    }
}
