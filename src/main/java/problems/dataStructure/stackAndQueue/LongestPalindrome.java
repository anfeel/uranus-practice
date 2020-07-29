package problems.dataStructure.stackAndQueue;

import org.junit.Test;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $ Id:LongestPalindrome, v 0.1 2020年07月29日 11:04 anfeel Exp $
 */
public class LongestPalindrome {

    @Test
    public void test1() {
        String s = "guxinnixgu";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void test2() {
        String s = "guxinixgu";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void test3() {
        String s = "g";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void test4() {
        String s = "guguguguguguguguguguguguxinix";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void test5() {
        String s = "abcdefghijlmnopqrstuvwxyzxinix";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void test6() {
        String s = "xinixabcdefghijlmnopqrstuvwxyz";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void test7() {
        String s = "xinix";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void test8() {
        String s = "cbba";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void test9() {
        String s = "aaaa";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void testa() {
        String s = "aaaaa";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void testb() {
        String s = "bbbbcaaaa";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void testc() {
        String s = "bbbbccccaaaa";
        System.out.println(longestPalindrome(s));
    }

    @Test
    public void testd() {
        String s = "bbbcccaaadddd";
        System.out.println(longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0)
            return "";
        int count = 1;
        int max = 1;
        String res = arr[0] + "";
        for (int i = 0; i < arr.length; i++) {
            int j = i - 1, k = i + 1;
            //当子串长度为奇数
            if (j >= 0 && k < arr.length && arr[j] == arr[k]) {
                count += 2;
                while (j >= 0 && k < arr.length && arr[j] == arr[k]) {
                    j--;
                    k++;
                    if (j >= 0 && k < arr.length && arr[j] == arr[k])
                        count += 2;
                }
                if (count > max) {
                    max = count;
                    res = s.substring(j + 1, k);
                }
                count = 1;
            }
            j = i - 1;
            k = i;
            //当子串长度为偶数
            if (j >= 0 && arr[j] == arr[k]) {
                count++;
                while (j >= 0 && k < arr.length && arr[j] == arr[k]) {
                    j--;
                    k++;
                    if (j >= 0 && k < arr.length && arr[j] == arr[k])
                        count += 2;
                }
                if (count > max) {
                    max = count;
                    res = s.substring(j + 1, k);
                }
                count = 1;
            }
            j = i;
            k = i + 1;
            if (k < arr.length && arr[j] == arr[k]) {
                count++;
                while (j >= 0 && k < arr.length && arr[j] == arr[k]) {
                    j--;
                    k++;
                    if (j >= 0 && k < arr.length && arr[j] == arr[k])
                        count += 2;
                }
                if (count > max) {
                    max = count;
                    res = s.substring(j + 1, k);
                }
                count = 1;
            }
        }
        return res;
    }
}
