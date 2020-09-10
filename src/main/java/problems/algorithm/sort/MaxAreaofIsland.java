package problems.algorithm.sort;

import java.util.Stack;

/**
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 示例 3:
 *
 *   [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *    [0,0,0,0,0,0,1,1,1,1,0,0,0],
 *    [0,1,1,0,1,1,1,0,0,0,0,0,0],
 *    [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *    [0,1,0,0,1,1,1,1,1,1,1,0,0],
 *    [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *    [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *    [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:MaxAreaofIsland, v 0.1 2020年09月09日 13:07 anfeel Exp $
 */
public class MaxAreaofIsland {

    public int maxAreaOfIsland(int[][] grid) {
        return 0;
    }

    public void getPath(int[][] grid, int i, int j, boolean[][] status, Stack<int[][]> stack, int[] area) {
        while (i < grid.length && j < grid[0].length) {
            if (grid[i][j] == 1) {
                if (i > 1 && !status[i - 1][j] && grid[i - 1][j] == 1) {
                    status[i - 1][j] = true;
                    stack.push(new int[][]{{i - 1, j}});
                    area[0]++;
                    getPath(grid, i - 1, j, status, stack, area);
                }
                if (j < grid[i].length - 1 && !status[i][j + 1] && grid[i][j + 1] == 1) {
                    status[i][j + 1] = true;
                    stack.push(new int[][]{{i, j + 1}});
                    area[0]++;
                    getPath(grid, i, j + 1, status, stack, area);
                }
                if (i < grid.length - 1 && !status[i + 1][j] && grid[i + 1][j] == 1) {
                    status[i + 1][j] = true;
                    stack.push(new int[][]{{i + 1, j}});
                    area[0]++;
                    getPath(grid, i + 1, j, status, stack, area);
                }
                if (j > 1 && !status[i][j - 1] && grid[i][j - 1] == 1) {
                    status[i][j - 1] = true;
                    stack.push(new int[][]{{i, j - 1}});
                    area[0]++;
                    getPath(grid, i, j - 1, status, stack, area);
                }
                stack.pop();
                return;
            } else {
                area[1] = Math.max(area[0], area[1]);
                area[0] = 0;
            }
            j++;
            if (j == grid[i].length) {
                j = 0;
                i++;
            }
        }
    }
}
