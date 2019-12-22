package problems.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。

    示例：
    
    输入: ["Hello", "Alaska", "Dad", "Peace"]
    输出: ["Alaska", "Dad"]
    
    注意：
    
    你可以重复使用键盘上同一字符。
    你可以假设输入的字符串将只包含字母。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/keyboard-row
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: FindWords.java, v 0.1 2019年11月7日 下午3:32:05 prd-fuy Exp $
 */
public class FindWords {
    public String[] findWords(String[] words) {
        if (words == null)
            return null;
        HashMap<String, Integer> keyboard = new HashMap<>();
        keyboard.put("q", 1);
        keyboard.put("w", 1);
        keyboard.put("e", 1);
        keyboard.put("r", 1);
        keyboard.put("t", 1);
        keyboard.put("y", 1);
        keyboard.put("u", 1);
        keyboard.put("i", 1);
        keyboard.put("o", 1);
        keyboard.put("p", 1);
        
        keyboard.put("a", 2);
        keyboard.put("s", 2);
        keyboard.put("d", 2);
        keyboard.put("f", 2);
        keyboard.put("g", 2);
        keyboard.put("h", 2);
        keyboard.put("j", 2);
        keyboard.put("k", 2);
        keyboard.put("l", 2);
        
        keyboard.put("z", 3);
        keyboard.put("x", 3);
        keyboard.put("c", 3);
        keyboard.put("v", 3);
        keyboard.put("b", 3);
        keyboard.put("n", 3);
        keyboard.put("m", 3);
        
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            String cur = words[i].toLowerCase();
            int pos = 0;
            for (int j = 0; j < cur.length(); j++) {
                int a = keyboard.get(cur.substring(j, j + 1));
                if (pos == 0)
                    pos = a;
                if (pos != a)
                    break;
                if (j == cur.length() - 1)
                    list.add(words[i]);
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    @Test
    public void test1() {
        String[] arr = { "Hello", "Alaska", "Dad", "Peace" };
        String[] res = findWords(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    
    @Test
    public void test2() {
        String[] arr = { "Helle", "ALASSADaska", "Dad", "QWE" };
        String[] res = findWords(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    
    @Test
    public void test3() {
        String[] arr = null;
        String[] res = findWords(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    
}
