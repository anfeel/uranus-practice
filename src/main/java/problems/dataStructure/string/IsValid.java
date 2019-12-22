package problems.dataStructure.string;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：
    
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
    
    示例 1:

    输入: "()"
    输出: true
    示例 2:
    
    输入: "()[]{}"
    输出: true
    示例 3:
    
    输入: "(]"
    输出: false
    示例 4:
    
    输入: "([)]"
    输出: false
    示例 5:
    
    输入: "{[]}"
    输出: true

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/valid-parentheses
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: IsValid.java, v 0.1 2019年12月6日 下午4:15:24 anfeel Exp $
 */
public class IsValid {
    public boolean isValid(String s) {
        if (s == null)
            return false;
        if (s.trim() == "")
            return true;
        Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{')
                stack.add(arr[i]);
            else if ((arr[i] == ')' && (stack.isEmpty() || stack.peek() != '(')) || (arr[i] == ']' && (stack.isEmpty() || stack.peek() != '['))
                     || (arr[i] == '}' && (stack.isEmpty() || stack.peek() != '{')))
                return false;
            else if ((arr[i] == ')' && stack.peek() == '(') || (arr[i] == ']' && stack.peek() == '[') || (arr[i] == '}' && stack.peek() == '{'))
                stack.pop();

        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    @Test
    public void test1() {
        Assert.assertTrue(isValid("()"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(isValid("()[]{}"));
    }

    @Test
    public void test3() {
        Assert.assertFalse(isValid("(]"));
    }

    @Test
    public void test4() {
        Assert.assertFalse(isValid("([)]"));
    }

    @Test
    public void test5() {
        Assert.assertTrue(isValid("{[]}"));
    }

    @Test
    public void test6() {
        Assert.assertFalse(isValid("{[(])}"));
    }

    @Test
    public void test7() {
        Assert.assertFalse(isValid("){[(])}"));
    }

    @Test
    public void test8() {
        Assert.assertTrue(isValid("  "));
    }

    @Test
    public void test9() {
        Assert.assertFalse(isValid(null));
    }

    @Test
    public void test10() {
        Assert.assertFalse(isValid("["));
    }

}
