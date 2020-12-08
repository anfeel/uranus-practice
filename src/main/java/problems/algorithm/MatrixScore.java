package problems.algorithm;

import org.junit.Test;

/**
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],
 *       [1,0,1,0],
 *       [1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],
 *        [1,0,0,1],
 *        [1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *  
 * 提示：
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $ Id:MatrixScore, v 0.1 2020年12月07日 17:59 anfeel Exp $
 */
public class MatrixScore {
    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0)
            return 0;
        int row = A.length;
        int col = A[0].length;
        int sum = 0;
        for (int i = 0; i < row; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    if (A[i][j] == 0)
                        A[i][j] = 1;
                    else
                        A[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < col; i++) {
            int count = 0;
            for (int j = 0; j < row; j++) {
                count += A[j][i];
            }
            if (2 * count < row) {
                for (int j = 0; j < row; j++) {
                    if (A[j][i] == 0)
                        A[j][i] = 1;
                    else
                        A[j][i] = 0;
                }
                count = row - count;
            }
            sum += (count * (1 << (col - 1 - i)));
        }
        return sum;
    }


    @Test
    public void test1() {
        int[][] a = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(matrixScore(a));
    }

    @Test
    public void test2() {
        int[][] a = {{0}, {0}, {0}};
        System.out.println(matrixScore(a));
    }

    @Test
    public void test3() {
        int[][] a = {{0, 1}, {1, 1}};
        System.out.println(matrixScore(a));
    }
}
