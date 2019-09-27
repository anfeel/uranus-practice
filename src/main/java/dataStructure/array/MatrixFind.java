package dataStructure.array;

import org.junit.Test;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author prd-fuy
 * @version $Id: MatrixFind.java, v 0.1 2019年8月22日 上午10:06:25 prd-fuy Exp $
 */
public class MatrixFind {
    
    public boolean Find(int target, int[][] array) {
        int row = array.length;
        if (row == 0)
            return false;
        int col = array[row - 1].length;
        if (col == 0)
            return false;
        int i = 0;
        int j = col - 1;
        if (target < array[0][0] || target > array[row - 1][col - 1])
            return false;
        while (true) {
            if (target == array[i][j]) {
                return true;
            } else if (target < array[i][j]) {
                j--;
                if (j < 0)
                    return false;
            } else if (target > array[i][j]) {
                i++;
                if (i == row)
                    return false;
            }
            
        }
        
    }
    
    @Test
    public void test1() {
        int[][] matrix = { { 1, 3, 6, 8, 14, 47 }, { 2, 9, 18, 24, 25, 48 }, { 4, 11, 19, 29, 30, 61 }, { 5, 12, 20, 38, 39, 66 }, { 7, 13, 45, 46, 60, 70 } };
        boolean f = Find(47, matrix);
        System.out.println(f);
    }
    
    @Test
    public void test2() {
        int[][] matrix = { { 1, 3, 6, 8, 14, 47 }, { 2, 9, 18, 24, 25, 48 }, { 4, 11, 19, 29, 30, 61 }, { 5, 12, 20, 38, 39, 66 }, { 7, 13, 45, 46, 60, 70 } };
        boolean f = Find(23, matrix);
        System.out.println(f);
    }
    
    @Test
    public void test3() {
        int[][] matrix = { { 1, 3, 6, 8, 14, 47 }, { 2, 9, 18, 24, 25, 48 }, { 4, 11, 19, 29, 30, 61 }, { 5, 12, 20, 38, 39, 66 }, { 7, 13, 45, 46, 60, 70 } };
        boolean f = Find(0, matrix);
        System.out.println(f);
    }
    
    @Test
    public void test4() {
        int[][] matrix = { { 1, 3, 6, 8, 14, 47 }, { 2, 9, 18, 24, 25, 48 }, { 4, 11, 19, 29, 30, 61 }, { 5, 12, 20, 38, 39, 66 }, { 7, 13, 45, 46, 60, 70 } };
        boolean f = Find(112, matrix);
        System.out.println(f);
    }
    
    @Test
    public void test5() {
        int[][] matrix = { { 1, 3, 6, 8, 14, 47 }, { 2, 9, 18, 24, 25, 48 }, { 4, 11, 19, 29, 30, 61 }, { 5, 12, 20, 38, 39, 66 }, { 7, 13, 45, 46, 60, 70 } };
        boolean f = Find(3, matrix);
        System.out.println(f);
    }
    
    @Test
    public void test6() {
        int[][] matrix = {};
        boolean f = Find(3, matrix);
        System.out.println(f);
    }
    
}
