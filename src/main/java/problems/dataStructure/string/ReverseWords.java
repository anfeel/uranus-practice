package problems.dataStructure.string;

import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * 通过次数75,328提交次数104,685
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:ReverseWords, v 0.1 2020年08月30日 9:04 anfeel Exp $
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return "";
        char[] arr = s.toCharArray();
        String res = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ' || i + 1 == arr.length) {
                if (i + 1 == arr.length)
                    stack.push(arr[i]);
                while (!stack.isEmpty())
                    res += stack.pop();
                if (arr[i] == ' ')
                    res += " ";
            } else {
                stack.push(arr[i]);
            }
        }
        return res;
    }

    @Test
    public void test1() {
        String string = "Let's take LeetCode contest";
        System.out.println(reverseWords(string));
    }

    @Test
    public void test2() {
        System.out.println(reverseWords("L"));
    }

    @Test
    public void test3() {
        System.out.println(reverseWords(null));
    }

    @Test
    public void test4() {
        System.out.println(reverseWords("do a little"));
    }
}
