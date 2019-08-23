package org.szfs.basic.web.demo.test.dataStruture;

import org.junit.Test;

/**
 * 值的平方
 * @author prd-fuy
 * @version $Id: NumPower.java, v 0.1 2019年8月30日 下午4:25:01 prd-fuy Exp $
 */
public class NumPower {
    
    public double Power(double base, int exponent) {
        double result = 0;
        if (exponent < 0) {
            result = 1 / base;
            for (int i = 1; i < -exponent; i++) {
                result = result * (1 / base);
            }
        } else if (exponent == 0) {
            if (base == 0)
                return 0;
            else
                result = base;
            return 1;
        } else {
            result = base;
            for (int i = 1; i < exponent; i++) {
                result = result * base;
            }
        }
        return result;
    }
    
    public double AdvPower(double base, int exponent) {
        double result = 0;
        if (exponent == 0) {
            if (base == 0)
                return 0;
            else
                return 1;
        } else {
            
        }
        
        return result;
    }
    
    @Test
    public void test1() {
        double base = -3.0;
        int exponent = -2;
        System.out.println("base = " + base + " exponent = " + exponent);
        
        //        long startTime = System.nanoTime();
        System.out.println("result = " + Power(base, exponent));
        //        long endTime = System.nanoTime();
        //        System.out.println("time = " + (endTime - startTime) + "ns");
    }
}
