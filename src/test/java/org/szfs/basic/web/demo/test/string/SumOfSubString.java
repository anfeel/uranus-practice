package org.szfs.basic.web.demo.test.string;

import org.junit.Test;

/**
 * 字符串中数字子串的求和
 * 给定一个字符串str，求其中全部数字串所代表的的数字之和
 * 1.忽略小数点字符，"A1.3"视为1和3
 * 2.若有"-"，奇数个视为负数，偶数个为整数，"A-1BC--12"包含数字-1和12
 * 举例：
 * str="A1CD2E33" , 返回36
 * str="A-1B--2C--D6E"，返回7
 * @author prd-fuy
 * @version $Id: SumOfSubString.java, v 0.1 2019年8月30日 上午11:25:26 prd-fuy Exp $
 */
public class SumOfSubString {
    
    public int sumSubString(String str) {
        if (str == null)
            return 0;
        char[] arr = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                int k = i, r = i;
                int sign = 0;
                while (k > 0) {
                    if (k - 1 > 0 && arr[k - 1] == '-')
                        k--;
                    else {
                        sign = i - k;
                        break;
                    }
                }
                while (r <= arr.length) {
                    if (r != arr.length && Character.isDigit(arr[r]))
                        r++;
                    else {
                        sum += Integer.parseInt(str.substring(i, r)) * (sign % 2 == 1 ? -1 : 1);
                        i = r;
                        break;
                    }
                }
            }
        }
        return sum;
    }
    
    @Test
    public void test1() {
        String str = "A1CD2E33";
        int res = sumSubString(str);
        System.out.println("result = " + res);
    }
    
    @Test
    public void test2() {
        String str = "A-1B--2C--D6E";
        int res = sumSubString(str);
        System.out.println("result = " + res);
    }
}
