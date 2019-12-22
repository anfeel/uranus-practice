package problems.dataStructure.string;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:
    
    输入: "abcabcbb"
    输出: 3 
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:
    
    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:
    
    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: LengthOfLongestSubstring.java, v 0.1 2019年12月11日 下午4:45:54 anfeel Exp $
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int sum = 0, sumMax = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
                sum++;
            } else {
                int pos = map.get(arr[i]);
                sum = 0;
                map = new HashMap<Character, Integer>();
                for (int j = pos + 1; j <= i; j++) {
                    map.put(arr[j], j);
                    sum++;
                }
            }
            sumMax = Math.max(sum, sumMax);
        }
        return sumMax;
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(5, lengthOfLongestSubstring("pwkdpwkewdkp"));
    }

    @Test
    public void test5() {
        Assert.assertEquals(5, lengthOfLongestSubstring("pwkdppdwek"));
    }

    @Test
    public void test6() {
        Assert.assertEquals(6, lengthOfLongestSubstring("pwkpedpacwped"));
    }

    @Test
    public void test7() {
        Assert.assertEquals(1, lengthOfLongestSubstring("p"));
    }

    @Test
    public void test8() {
        Assert.assertEquals(0, lengthOfLongestSubstring(""));
    }
}
