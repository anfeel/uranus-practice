package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
    
    Example:
    
    board =
    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]
    
    Given word = "ABCCED", return true.
    Given word = "SEE", return true.
    Given word = "ABCB", return false.
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/word-search
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: Exist.java, v 0.1 2019年12月17日 下午2:42:56 anfeel Exp $
 */
public class Exist {
    public boolean exist3(char[][] board, String word) {
        HashMap<Character, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (!map.containsKey(c)) {
                    List<int[]> q = new ArrayList<>();
                    q.add(new int[] { i, j });
                    map.put(c, q);
                } else {
                    List<int[]> q = map.get(c);
                    q.add(new int[] { i, j });
                    map.put(c, q);
                }
            }
        }
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (!map.containsKey(w[i]))
                return false;
        }
        HashMap<Character, List<int[]>> res = new HashMap<>();
        for (int i = 0; i < w.length; i++) {
            List<int[]> cur = map.get(w[i]);
            if (cur.size() == 0)
                return false;
            List<int[]> next = null;
            if (i + 1 < w.length) {
                next = map.get(w[i + 1]);
            } else {
                if (cur.size() > 0)
                    return true;
            }
            int curLen = cur.size();
            for (int j = 0; j < curLen; j++) {
                int nextLen = next.size();
                for (int k = 0; k < nextLen; k++) {
                    int[] a = cur.get(j);
                    int[] b = next.get(k);
                    List<int[]> usedL = res.get(w[i + 1]);
                    if (usedL != null) {
                        int count = 0;
                        for (int[] usedP : usedL) {
                            if (usedP[0] == b[0] && usedP[1] == b[1]) {
                                count++;
                            }
                        }
                        if (count == usedL.size())
                            return false;
                    }
                    if (Math.abs(Math.subtractExact(a[0], b[0])) > 1 || Math.abs(Math.subtractExact(a[1], b[1])) > 1) {
                        next.remove(k);
                        nextLen--;
                        k--;
                        map.put(w[i + 1], next);
                    } else {
                        List<int[]> tmp = new ArrayList<int[]>();
                        tmp.add(a);
                        res.put(w[i], tmp);
                    }
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (word.isEmpty())
            return true;
        HashMap<Character, List<int[]>> charToPosMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (!charToPosMap.containsKey(c)) {
                    List<int[]> q = new ArrayList<>();
                    q.add(new int[] { i, j });
                    charToPosMap.put(c, q);
                } else {
                    List<int[]> q = charToPosMap.get(c);
                    q.add(new int[] { i, j });
                    charToPosMap.put(c, q);
                }
            }
        }
        char[] wArr = word.toCharArray();
        for (int i = 0; i < wArr.length; i++) {
            if (!charToPosMap.containsKey(wArr[i]))
                return false;
        }
        //HashMap<Character, List<int[]>> map: 每个字符在board中出现的位置
        //char[] wArr: 字符数组
        //Stack<> stack: 当前搜索路径
        //boolean[][] status: 当前array状态位置

        return checkExist(new Stack<int[]>(), new boolean[board.length][board[0].length], new boolean[wArr.length], wArr, charToPosMap);
    }

    public boolean checkExist(Stack<int[]> stack, boolean[][] posStatus, boolean[] charStatus, char[] arr, HashMap<Character, List<int[]>> map) {
        if (arr.length == stack.size())
            return true;
        for (int i = 0; i < arr.length; i++) {
            if (charStatus[i] != true) {
                List<int[]> cur = map.get(arr[i]);
                for (int j = 0; j < cur.size(); j++) {
                    int[] curPos = cur.get(j);
                    if (posStatus[curPos[0]][curPos[1]] != true) {
                        int[] lastPos = null;
                        if (!stack.isEmpty()) {
                            lastPos = stack.peek();
                        }
                        if (stack.isEmpty() || (!stack.isEmpty() && (((Math.abs(Math.subtractExact(lastPos[0], curPos[0])) == 1 & (Math.abs(Math.subtractExact(lastPos[1], curPos[1])) == 0)))
                                                                     ^ ((Math.abs(Math.subtractExact(lastPos[0], curPos[0])) == 0 & (Math.abs(Math.subtractExact(lastPos[1], curPos[1])) == 1)))))) {
                            posStatus[curPos[0]][curPos[1]] = true;
                            charStatus[i] = true;
                            stack.push(curPos);
                            boolean r = checkExist(stack, posStatus, charStatus, arr, map);
                            if (r)
                                return true;
                            stack.pop();
                            charStatus[i] = false;
                            posStatus[curPos[0]][curPos[1]] = false;
                        } else {
                            if (j == cur.size() - 1)
                                return false;
                        }
                    }
                    if (j == cur.size() - 1)
                        return false;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        char[][] arr = new char[][] { {} };
        Assert.assertFalse(exist(arr, "B"));
    }

    @Test
    public void test0() {
        char[][] arr = new char[][] { {} };
        Assert.assertTrue(exist(arr, ""));
    }

    //    ['A','B','C','E'],
    //    ['S','F','C','S'],
    //    ['A','D','E','E']
    @Test
    public void test1() {
        char[][] arr = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        Assert.assertTrue(exist(arr, "ASA"));
    }

    @Test
    public void test2() {
        char[][] arr = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        Assert.assertFalse(exist(arr, "ABCD"));
    }

    @Test
    public void test3() {
        char[][] arr = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        Assert.assertFalse(exist(arr, "ABB"));
    }

    @Test
    public void test4() {
        char[][] arr = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        Assert.assertTrue(exist(arr, "ABCCED"));
    }

    //    ['A','B','C','E'],
    //    ['S','F','C','S'],
    //    ['A','D','E','E']
    @Test
    public void test5() {
        char[][] arr = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        Assert.assertTrue(exist(arr, "SEE"));
    }

    //    ['A','B','C','E'],
    //    ['S','F','C','S'],
    //    ['A','D','E','E']
    @Test
    public void test6() {
        char[][] arr = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        Assert.assertFalse(exist(arr, "ABCB"));
    }

    @Test
    public void test7() {
        char[][] arr = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        Assert.assertFalse(exist(arr, "AAA"));
    }

    //    ['A','B','C','E'],
    //    ['A','F','C','S'],
    //    ['A','B','E','E']
    @Test
    public void test8() {
        char[][] arr = new char[][] { { 'A', 'B', 'C', 'E' }, { 'A', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        Assert.assertTrue(exist(arr, "AAA"));
    }

    //    ['A','B','C','E'],
    //    ['S','F','C','S'],
    //    ['A','B','E','E']
    @Test
    public void test9() {
        char[][] arr = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'B', 'E', 'E' } };
        Assert.assertTrue(exist(arr, "SFBE"));
    }

    //    ['A','B','C','E'],
    //    ['S','F','C','S'],
    //    ['A','B','E','E']
    @Test
    public void testa() {
        char[][] arr = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'B', 'E', 'E' } };
        Assert.assertTrue(exist(arr, "ABFSA"));
    }

    //    ['D','B','C','E'],
    //    ['S','F','C','S'],
    //    ['D','B','E','E']
    @Test
    public void testb() {
        char[][] arr = new char[][] { { 'D', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'D', 'B', 'E', 'E' } };
        Assert.assertTrue(exist(arr, "BDSDBCCF"));
    }

    //    ['D','B','C','E'],
    //    ['S','E','C','S'],
    //    ['D','B','E','E']
    @Test
    public void testc() {
        char[][] arr = new char[][] { { 'D', 'B', 'C', 'E' }, { 'S', 'E', 'C', 'S' }, { 'D', 'B', 'E', 'E' } };
        Assert.assertTrue(exist(arr, "BECES"));
    }

    //    ['A','B'],
    //    ['C','D'],
    @Test
    public void testd() {
        char[][] arr = new char[][] { { 'A', 'B' }, { 'C', 'D' } };
        Assert.assertFalse(exist(arr, "ABCD"));
    }

    //    ["C","A","A"],
    //    ["A","A","A"],
    //    ["B","C","D"]
    @Test
    public void teste() {
        char[][] arr = new char[][] { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
        Assert.assertTrue(exist(arr, "AAB"));
    }

}
