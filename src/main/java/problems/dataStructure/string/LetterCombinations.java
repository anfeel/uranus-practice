package problems.dataStructure.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $ Id:LetterCombinations, v 0.1 2020年08月26日 12:02 anfeel Exp $
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        char[][] word = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};
        int[] arr = new int[digits.length()];
        for (int i = 0; i < arr.length; i++) {
            if (!Character.isDigit(digits.charAt(i))) {
                return res;
            }
            arr[i] = Integer.parseInt(digits.substring(i, i + 1));
            if (arr[i] < 2 || arr[i] > 10) {
                return res;
            }
        }
        getStr(word, new Stack<Character>(), arr, 0, 0, res);
        return res;
    }

    public void getStr(char[][] word, Stack<Character> stack, int[] arr, int row, int col, List<String> res) {
        if (row == arr.length) {
            String str = "";
            for (char c : stack) {
                str += c;
            }
            res.add(str);
            return;
        }

        for (int i = row; i < arr.length; i++) {
            for (int j = 0; j < word[arr[i] - 2].length; j++) {
                stack.add(word[arr[i] - 2][j]);
                getStr(word, stack, arr, row + 1, j, res);
                stack.pop();
                if (i == arr.length - 1 && j == word[arr[i] - 2].length - 1)
                    break;
            }
            break;
        }
    }

    @Test
    public void test1() {
        List<String> res = letterCombinations("23");
        for (String str : res
        ) {
            System.out.println(str);
        }
    }

    @Test
    public void test2() {
        List<String> res = letterCombinations("2");
        for (String str : res
        ) {
            System.out.println(str);
        }
    }

    @Test
    public void test3() {
        List<String> res = letterCombinations("");
        for (String str : res
        ) {
            System.out.println(str);
        }
    }

    @Test
    public void test4() {
        List<String> res = letterCombinations("1234");
        for (String str : res
        ) {
            System.out.println(str);
        }
    }

    @Test
    public void test5() {
        List<String> res = letterCombinations("2345");
        for (String str : res
        ) {
            System.out.println(str);
        }
    }

    @Test
    public void test6() {
        List<String> res = letterCombinations("27");
        for (String str : res
        ) {
            System.out.println(str);
        }
    }

    @Test
    public void test7() {
        List<String> res = letterCombinations("7");
        for (String str : res
        ) {
            System.out.println(str);
        }
    }


    @Test
    public void testa() {
        String digits = "1234";
        int[] arr = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            System.out.println(Integer.parseInt(digits.substring(i, i + 1)));
        }
    }

    @Test
    public void testb() {
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        System.out.println(stack.toString());
        List<String> list = new ArrayList<>();
        list.add(stack.toString());
        for (char c : stack
        ) {
            System.out.println(c + "");
        }

    }
}
