package problems.dataStructure.string;

import org.junit.Test;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。

    输入为非空字符串且只包含数字 1 和 0。
    
    示例 1:
    
    输入: a = "11", b = "1"
    输出: "100"
    示例 2:
    
    输入: a = "1010", b = "1011"
    输出: "10101"
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/add-binary
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: AddBinary.java, v 0.1 2019年10月30日 下午5:09:58 prd-fuy Exp $
 */
public class AddBinary {
    
    public String addBinary(String a, String b) {
        int res = 0;
        int i = a.length() - 1, j = b.length() - 1;
        String result = "";
        if (i == 0 && j == 0 && a.charAt(i) == '0' && b.charAt(j) == '0')
            return "0";
        while (i >= 0 || j >= 0) {
            if (((i < 0 && b.charAt(j) == '0') || (j < 0 && a.charAt(i) == '0')) && res == 0) {
                res = 0;
                result = "0" + result;
            } else if (((i < 0 && b.charAt(j) == '1') || (j < 0 && a.charAt(i) == '1')) && res == 0) {
                res = 0;
                result = "1" + result;
            } else if (((i < 0 && b.charAt(j) == '1') || (j < 0 && a.charAt(i) == '1')) && res == 1) {
                res = 1;
                result = "0" + result;
            } else if (((i < 0 && b.charAt(j) == '0') || (j < 0 && a.charAt(i) == '0')) && res == 1) {
                res = 0;
                result = "1" + result;
            } else if (a.charAt(i) == '1' && b.charAt(j) == '1' && res == 1) {
                res = 1;
                result = "1" + result;
            } else if (((a.charAt(i) == '1' || b.charAt(j) == '1') && res == 1) || ((a.charAt(i) == '1' && b.charAt(j) == '1') && res == 0)) {
                res = 1;
                result = "0" + result;
            } else if ((a.charAt(i) == '1' || b.charAt(j) == '1') && res == 0) {
                res = 0;
                result = "1" + result;
            } else if (a.charAt(i) == '0' && b.charAt(j) == '0' && res == 1) {
                res = 0;
                result = "1" + result;
            } else if (a.charAt(i) == '0' && b.charAt(j) == '0' && res == 0) {
                res = 0;
                result = "0" + result;
            }
            i--;
            j--;
            if (i < 0 && j < 0 && res == 1) {
                res = 0;
                result = "1" + result;
            }
        }
        return result;
    }
    
    @Test
    public void test1() {
        String res = addBinary("11", "10");
        System.out.println("res = " + res);
    }
    
    @Test
    public void test2() {
        String res = addBinary("1010", "1011");
        System.out.println("res = " + res);
    }
    
    @Test
    public void test3() {
        String res = addBinary("11", "1");
        System.out.println("res = " + res);
    }
    
    @Test
    public void test4() {
        String res = addBinary("1", "111");
        System.out.println("res = " + res);
    }
    
    @Test
    public void test5() {
        String res = addBinary("101111", "10");
        System.out.println("res = " + res);
    }
    
    @Test
    public void test6() {
        String res = addBinary("10", "101111");
        System.out.println("res = " + res);
    }
    
    @Test
    public void test7() {
        String res = addBinary("0", "0");
        System.out.println("res = " + res);
    }
    
    @Test
    public void test8() {
        String res = addBinary("0", "1");
        System.out.println("res = " + res);
    }
    
    @Test
    public void test9() {
        String res = addBinary("100", "110010");
        System.out.println("res = " + res);
    }
    
}
