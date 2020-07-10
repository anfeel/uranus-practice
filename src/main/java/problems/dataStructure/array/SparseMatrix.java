package problems.dataStructure.array;

/**
 * 稀疏矩阵转换
 * @author anfeel
 * @version $ Id:SparseMatrix, v 0.1 2020年07月10日 14:50 anfeel Exp $
 */
public class SparseMatrix {

    public int[][] Matrix2Array(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int sum = 0;
        for (int[] r : matrix) {
            for (int d : r) {
                if (d != 0)
                    sum++;
            }
        }
        int[][] array = new int[sum + 1][3];
        array[0][0] = row;
        array[0][1] = col;
        array[0][2] = sum;
        int ar = 1;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (matrix[r][c] != 0) {
                    array[ar][0] = r;
                    array[ar][1] = c;
                    array[ar][2] = matrix[r][c];
                    ar++;
                }
            }
        }
        return array;
    }

    public int[][] Array2Matrix(int[][] array) {
        int row = array[0][0];
        int col = array[0][1];
        int[][] matrix = new int[row][col];
        for (int[] r : array) {
            matrix[r[0]][r[1]] = r[2];
        }
        return matrix;
    }
}
