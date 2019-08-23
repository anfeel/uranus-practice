package org.szfs.basic.web.demo.test.dataStruture;

import org.junit.Test;

/**
 * 左旋转字符串
 * @author prd-fuy
 * @version $Id: LeftRotateStrings.java, v 0.1 2019年8月27日 上午10:01:10 prd-fuy Exp $
 */
public class LeftRotateStrings {
    public String LeftRotateString(String str, int n) {
        int l = str.length();
        if (l == 0)
            return "";
        int m = n >= 0 ? n % l : -n % l;
        String tmp = str + str;
        String ret = tmp.substring(m, l + m);
        return ret;
        
    }
    
    @Test
    public void test1() {
        String str = "abcXYZdef";
        int n = 3;
        String ret = LeftRotateString(str, n);
        System.out.println(ret);
    }
    
    @Test
    public void test2() {
        String str = "abcXYZdef";
        int n = 0;
        String ret = LeftRotateString(str, n);
        System.out.println(ret);
    }
    
    @Test
    public void test3() {
        String str = "abcXYZdef";
        int n = -4;
        String ret = LeftRotateString(str, n);
        System.out.println(ret);
    }
    
    @Test
    public void test4() {
        String str = "abcXYZdef";
        int n = 12;
        String ret = LeftRotateString(str, n);
        System.out.println(ret);
    }
    
    @Test
    public void test5() {
        String str = "abcXYZdef";
        int n = 110;
        String ret = LeftRotateString(str, n);
        System.out.println(ret);
    }
    
    @Test
    public void test6() {
        String str = "abcXYZdef";
        int n = -113;
        String ret = LeftRotateString(str, n);
        System.out.println(ret);
    }
    
    @Test
    public void test7() {
        String str = "";
        int n = -113;
        String ret = LeftRotateString(str, n);
        System.out.println(ret);
    }
    
    @Test
    public void test8() {
        String str = "abcX   YZdef";
        int n = 123;
        String ret = LeftRotateString(str, n);
        System.out.println(ret);
    }
    
    @Test
    public void test9() {
        String str = "abcX   YZdef";
        int n = -23;
        String ret = LeftRotateString(str, n);
        System.out.println(ret);
    }
}
