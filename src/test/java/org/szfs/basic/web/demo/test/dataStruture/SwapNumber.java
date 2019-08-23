package org.szfs.basic.web.demo.test.dataStruture;

import org.junit.Test;

/**
 * 不使用第三个变量的情况下交换两个数字
 * @author prd-fuy
 * @version $Id: SwapNumber.java, v 0.1 2019年9月5日 下午4:34:35 prd-fuy Exp $
 */
public class SwapNumber {
    
    @Test
    public void test1() {
        int a = 5, b = 13;
        System.out.println("a = " + a + " , b = " + b);
        a = b - a;//a=8
        b = b - a;//b=5
        a = a + b;//a=13
        System.out.println("a = " + a + " , b = " + b);
    }
    
    @Test
    public void test2() {
        int a = 5, b = 13;
        System.out.println("a = " + a + " , b = " + b);
        a = b + a;//a=18
        b = a - b;//b=5
        a = a - b;//a=13
        System.out.println("a = " + a + " , b = " + b);
    }
    
    @Test
    public void test3() {
        int a = 5, b = 13;
        System.out.println("a = " + a + " , b = " + b);
        a = a ^ b;//a = 0101 , b = 1101 , a ^ b = 1000
        b = a ^ b;//a = 1000 , b = 1101 , a ^ b = 0101
        a = a ^ b;//a = 1000 , b = 0101 , a ^ b = 1101
        System.out.println("a = " + a + " , b = " + b);
    }
}
