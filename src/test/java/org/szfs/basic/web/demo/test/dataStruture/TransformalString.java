package org.szfs.basic.web.demo.test.dataStruture;

import java.util.Arrays;

import org.junit.Test;

/**
 * 判断字符串是否互为变形词
 * 给定两个字符串str1和str2，如果str1和str2中出现的字符种类一样且每种字符出现的次数也一样，那么str1和str2互为变形词
 * 例如：
 * "132","123", 返回true
 * "123","2331", 放回false
 * @author prd-fuy
 * @version $Id: TransformalString.java, v 0.1 2019年8月29日 下午3:29:52 prd-fuy Exp $
 */
public class TransformalString {
    
    public boolean validTransformalString(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        String[] arr1 = str1.split("");
        String[] arr2 = str2.split("");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) {
                    String tmp = arr2[j];
                    arr2[j] = arr2[i];
                    arr2[i] = tmp;
                    break;
                }
                if (j == arr2.length - 1)
                    return false;
            }
        }
        if (Arrays.equals(arr1, arr2))
            return true;
        return false;
    }
    
    public boolean validTransformalString2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < arr1.length; i++) {
            map[arr1[i]]++;
        }
        for (int i = 0; i < arr2.length; i++) {
            if (map[arr2[i]]-- == 0)
                return false;
        }
        return true;
    }
    
    @Test
    public void splitTest1() {
        String str1 = "1323";
        String str2 = "1332";
        System.out.println("str1 =" + str1 + ", str2 = " + str2 + " \n is transformal String?  " + validTransformalString2(str1, str2));
    }
    
    @Test
    public void splitTest2() {
        String str1 = "132";
        String str2 = "1332";
        System.out.println("str1 =" + str1 + ", str2 = " + str2 + "\n is transformal String?  " + validTransformalString2(str1, str2));
    }
    
    @Test
    public void splitTest3() {
        String str1 = "1312314";
        String str2 = "1312333";
        System.out.println("str1 =" + str1 + ", str2 = " + str2 + "\n is transformal String?  " + validTransformalString2(str1, str2));
    }
    
    @Test
    public void splitTest4() {
        String str1 = "123155aabb";
        String str2 = "a5b5a1b231";
        System.out.println("str1 =" + str1 + ", str2 = " + str2 + "\n is transformal String?  " + validTransformalString2(str1, str2));
    }
    
}
