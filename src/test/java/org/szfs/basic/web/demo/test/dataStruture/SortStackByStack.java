package org.szfs.basic.web.demo.test.dataStruture;

import java.util.Stack;

import org.junit.Test;

/**
 * 用一个栈实现另一个栈的排序
 * 思路：遍历原始栈，将当前最小的元素push到原始栈，循环该过程，相当于实现冒泡排序
 * @author prd-fuy
 * @version $Id: SortStackByStack.java, v 0.1 2019年8月20日 上午11:03:31 prd-fuy Exp $
 */
public class SortStackByStack {
    private Stack<Integer> stackOri;
    private Stack<Integer> stackUtil;
    
    public SortStackByStack() {
        this.stackOri = new Stack<Integer>();
        this.stackUtil = new Stack<Integer>();
        
    }
    
    public void sort() {
        for (int r = 0; r < stackOri.size(); r++) {
            while (!stackOri.isEmpty()) {
                int i = this.stackOri.pop();
                if (stackUtil.isEmpty()) {
                    this.stackUtil.push(i);
                } else {
                    int j = stackUtil.peek();
                    if (i > j) {
                        int tmp = stackUtil.pop();
                        stackUtil.push(i);
                        stackUtil.push(tmp);
                    } else {
                        stackUtil.push(i);
                    }
                }
            }
            while (!stackUtil.isEmpty()) {
                stackOri.push(stackUtil.pop());
            }
        }
    }
    
    @Test
    public void test1() {
        SortStackByStack stack = new SortStackByStack();
        stack.stackOri.push(3);
        stack.stackOri.push(4);
        stack.stackOri.push(1);
        stack.stackOri.push(5);
        stack.stackOri.push(2);
        stack.sort();
        System.out.println("Stack pop : " + stack.stackOri.pop());
        System.out.println("Stack pop : " + stack.stackOri.pop());
        System.out.println("Stack pop : " + stack.stackOri.pop());
        System.out.println("Stack pop : " + stack.stackOri.pop());
        System.out.println("Stack pop : " + stack.stackOri.pop());
    }
}
