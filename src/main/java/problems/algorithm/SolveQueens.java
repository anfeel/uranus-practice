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
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 3 && n > 1)
            return res;
        int[] board = new int[n];
        place(board, 0, res);
        return res;
    }

    /**
     * 放置点位到当前棋盘
     * @param board
     * @param n
     * @param list
     */
    public void place(int[] board, int n, List<List<String>> list) {
        //当棋盘已经摆满，保存当前结果
        if (board.length == n) {
            list.add(transform(board));
            return;
        }
        //在当前第n列遍历查找合适位置
        for (int i = 0; i < board.length; i++) {
            //先将当前i行保存至n列
            board[n] = i;
            //检查第n列的位置与前面n-1列是否冲突
            if (check(board, n))
                //如果不冲突，继续查找n+1的合适位置
                place(board, n + 1, list);

        }
    }

    /**
     * 将int数组转化String数组
     * @param board
     * @return
     */
    public List<String> transform(int[] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < board.length; j++) {
                if (j != board[i])
                    sb.append(".");
                else
                    sb.append("Q");
            }
            list.add(sb.toString());
        }
        return list;
    }

    /**
     * 检查当前点位能否放置皇后
     * @param board
     * @param j 当前列
     * @return
     */
    public boolean check(int[] board, int j) {
        for (int i = 0; i < j; i++) {
            if (board[i] == board[j] || (Math.abs(board[j] - board[i]) == Math.abs(j - i)))
                return false;
        }
        return true;
    }

    @Test
    public void test1() {
        List<List<String>> res = solveNQueens(4);
        System.out.println(res.size());
        for (List<String> list : res) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
