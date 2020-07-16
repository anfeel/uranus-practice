package problems.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *
 * 注意：本题相对原题做了扩展
 *
 * 示例:
 *
 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $ Id:SolveQueens, v 0.1 2020年07月15日 16:16 anfeel Exp $
 */
public class SolveQueens {
    @Test
    public void test1() {
        List<List<String>> res = solveNQueens(8);
        System.out.println(res.size());
        for (List<String> list : res) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    @Test
    public void test2() {
        List<List<String>> res = solveNQueens(1);
        System.out.println(res.size());
        for (List<String> list : res) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 3 && n > 1)
            return res;
        int[] arr = new int[n];
        place(0, n, arr, res);
        return res;
    }

    private void place(int cur, int size, int[] arr, List<List<String>> res) {
        if (cur == size) {
            res.add(transform(arr));
            return;
        }
        for (int i = 0; i < size; i++) {
            arr[cur] = i;
            if (check(cur, arr))
                place(cur + 1, size, arr, res);
        }

    }

    /**
     * 将一维数组arr转换至List<String>
     * @return
     */
    private List<String> transform(int[] arr) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String s = "";
            for (int j = 0; j < arr.length; j++) {
                if (j == arr[i])
                    s += "Q";
                else
                    s += ".";
            }
            res.add(s);
        }
        return res;
    }

    /**
     * 检查当前位置
     * @return
     */
    private boolean check(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i]))
                return false;
        }
        return true;
    }
}
