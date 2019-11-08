package dataStructure.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。

    示例 1:
    
    输入:
    s = "aaabb", k = 3
    
    输出:
    3
    
    最长子串为 "aaa" ，其中 'a' 重复了 3 次。
    示例 2:
    
    输入:
    s = "ababbc", k = 2
    
    输出:
    5
    
    最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: LongestSubstring.java, v 0.1 2019年11月8日 上午11:02:19 prd-fuy Exp $
 */
public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        if (s == null || k < 1 || s.length() < k)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) < k)
                list.add(i);
        }
        if (list.size() == 1)
            return s.length();
        List<String> sub = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0)
                sub.add(s.substring(0, list.get(i + 1)));
            else if (i != list.size() - 1)
                sub.add(s.substring(list.get(i) + 1, list.get(i + 1)));
            else
                sub.add(s.substring(list.get(i) + 1));
        }
        int[] lenArr = new int[list.size()];
        for (int i = 0; i < sub.size(); i++) {
            lenArr[i] = longestSubstring(sub.get(i), k);
        }
        int max = 0;
        for (int i = 0; i < lenArr.length; i++) {
            if (lenArr[i] > max)
                max = lenArr[i];
        }
        return max;
    }
    
    @Test
    public void test1() {
        System.out.println(longestSubstring("aaabb", 3));
    }
    
    @Test
    public void test2() {
        System.out.println(longestSubstring("ababbc", 2));
    }
    
    @Test
    public void test3() {
        System.out.println(longestSubstring("aaacabbcddcac", 3));
    }
    
    @Test
    public void test4() {
        System.out.println(longestSubstring("abcdaaacccbccccdaa", 3));
    }
    
    @Test
    public void test5() {
        System.out.println(longestSubstring("abcdaaabcccbccccdaa", 3));
    }
    
    @Test
    public void test6() {
        System.out.println(longestSubstring("        ", 3));
    }
}
