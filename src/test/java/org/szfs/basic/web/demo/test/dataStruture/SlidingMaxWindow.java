package org.szfs.basic.web.demo.test.dataStruture;

import org.junit.Test;

/**
 * 生成窗口最大值数组
 * 有一个整形数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置
 * 例如数组为【4,3,5,4,3,3,6,7】，窗口大小为3时，结果应返回{5,5,5,4,6,7}
 * 思路1：时间复杂度O(arr.len * window)
 * 思路2：时间复杂度o(arr.len)
 * @author prd-fuy
 * @version $Id: SlidingMaxWindow.java, v 0.1 2019年8月20日 下午6:22:16 prd-fuy Exp $
 */
public class SlidingMaxWindow {
    private int[] array;
    private int   window;
    
    public SlidingMaxWindow() {
        
    }
    
    public void setArray(int[] array) {
        this.array = array;
    }
    
    public void setWindow(int window) {
        this.window = window;
    }
    
    public int[] getMaxValueArray() {
        if (array.length < window)
            throw new RuntimeException("value of window cannot be bigger than array.length");
        int[] output = new int[array.length - window + 1];
        for (int i = 0; i <= array.length - window; i++) {
            int max = 0;
            for (int j = i; j < window + i; j++) {
                if (array[j] > max)
                    max = array[j];
            }
            output[i] = max;
        }
        return output;
    }
    
    /**
     * 
     * @return
     */
    public int[] getMaxValueArray2() {
        if (array.length < window)
            throw new RuntimeException("value of window cannot be bigger than array.length");
        if (window == 1)
            return this.array;
        int[] output = new int[array.length - window + 1];
        return output;
    }
    
    @Test
    public void test1() {
        int[] array = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int window = 3;
        SlidingMaxWindow slidingMaxWindow = new SlidingMaxWindow();
        slidingMaxWindow.setArray(array);
        slidingMaxWindow.setWindow(window);
        int[] output = slidingMaxWindow.getMaxValueArray();
        for (int i = 0; i < output.length; i++) {
            System.out.println("output [" + i + "] : " + output[i]);
        }
    }
}
