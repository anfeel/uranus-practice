package dataStructure.array;

import java.util.ArrayList;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4 X 4矩阵： 
 *   1   2   3   4 
 *   5   6   7   8 
 *   9 10 11 12 
 * 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author prd-fuy
 * @version $Id: MatrixPrintClockwise.java, v 0.1 2019年8月22日 下午2:40:06 prd-fuy Exp $
 */
public class MatrixPrintClockwise {
    
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[row - 1].length;
        int i = 0, j = 0;
        int m = row;
        int n = col;
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            while (j < col - 1) {
                list.add(matrix[i][j]);
                j++;
            }
            if (i == row - 1) {
                list.add(matrix[i][j]);
                break;
            }
            while (i < row - 1) {
                list.add(matrix[i][j]);
                i++;
            }
            if (j == n - col) {
                list.add(matrix[i][j]);
                break;
            }
            while ((j > n - col)) {
                list.add(matrix[i][j]);
                j--;
            }
            while (i > m - row) {
                list.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
            
            col -= 1;
            row -= 1;
            
            if ((col < 1 || row < 1) || (row == i || col == j))
                break;
            
        }
        return list;
        
    }
    
    @Test
    public void test0() {
        int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
        ArrayList<Integer> list = printMatrix(matrix);
        
        System.out.println(list);
    }
    
    @Test
    public void test1() {
        int[][] matrix = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 }, { 19, 20, 21, 22, 23, 24 }, { 25, 26, 27, 28, 29, 30 }, { 31, 32, 33, 34, 35, 36 } };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
    
    @Test
    public void test2() {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, { 13, 14, 15 } };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
    
    @Test
    public void test3() {
        int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
    
    @Test
    public void test4() {
        int[][] matrix = { { 1, 2, 3, 4 }, { 6, 7, 8, 9 }, { 11, 12, 13, 14 }, { 16, 17, 18, 19 }, { 21, 22, 23, 24 } };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
    
    @Test
    public void test5() {
        int[][] matrix = { { 1 } };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
    
    @Test
    public void test6() {
        int[][] matrix = { { 1, 2 } };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
    
    @Test
    public void test7() {
        int[][] matrix = { { 2 }, { 1 } };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
    
    @Test
    public void test8() {
        int[][] matrix = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
    
    @Test
    public void test9() {
        int[][] matrix = { { 1, 2, 3, 4, 5 } };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
    
    @Test
    public void test91() {
        int[][] matrix = { { 1, 2 }, { 3, 4 } };
        ArrayList<Integer> list = printMatrix(matrix);
        ArrayList<Integer> list2 = Lists.newArrayList(1, 2, 4, 3);
        System.out.println("test 91 : ");
        System.out.println(list2);
        System.out.println(list);
        
    }
    
    @Test
    public void test92() {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
    
}
