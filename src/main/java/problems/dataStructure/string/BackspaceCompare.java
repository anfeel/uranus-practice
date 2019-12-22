package problems.dataStructure.string;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

    示例 1：
    
    输入：S = "ab#c", T = "ad#c"
    输出：true
    解释：S 和 T 都会变成 “ac”。
    示例 2：
    
    输入：S = "ab##", T = "c#d#"
    输出：true
    解释：S 和 T 都会变成 “”。
    示例 3：
    
    输入：S = "a##c", T = "#a#c"
    输出：true
    解释：S 和 T 都会变成 “c”。
    示例 4：
    
    输入：S = "a#c", T = "b"
    输出：false
    解释：S 会变成 “c”，但 T 仍然是 “b”。
     
    
    提示：
    
    1 <= S.length <= 200
    1 <= T.length <= 200
    S 和 T 只含有小写字母以及字符 '#'。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/backspace-string-compare
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: BackspaceCompare.java, v 0.1 2019年11月3日 下午9:47:36 anfeel Exp $
 */
public class BackspaceCompare {

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack = new Stack<>();
        char[] cs = S.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '#') {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(cs[i]);
        }
        String s = null;
        while (!stack.isEmpty()) {
            s = s + stack.pop();
        }
        char[] ct = T.toCharArray();
        for (int i = 0; i < ct.length; i++) {
            if (ct[i] == '#') {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(ct[i]);
        }
        String t = null;
        while (!stack.isEmpty()) {
            t = t + stack.pop();
        }
        if (null != s && null != t)
            return s.equals(t);
        else if (null == s && null == t)
            return true;
        return false;
    }

    @Test
    public void test1() {
        Assert.assertTrue(backspaceCompare("ab#c", "ad#c"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(backspaceCompare("ab##", "c#d#"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(backspaceCompare("a##c", "#a#c"));
    }

    @Test
    public void test4() {
        Assert.assertFalse(backspaceCompare("a#c", "b"));
    }
}
