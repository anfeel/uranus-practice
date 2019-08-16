package org.szfs.basic.web.demo.test.dataStruture;

import java.util.Stack;

import org.junit.Test;

/**
 * 实现一个特殊的栈，在保留栈的基本功能的基础上，再实现返回栈中最小元素的功能
 * 想法1：构建两个栈，一个为普通栈保存正常数据，另一个存放当前最小数据
 * @author prd-fuy
 * @version $Id: GetMinStack.java, v 0.1 2019年8月16日 上午8:38:38 prd-fuy Exp $
 */
public class GetMinStack {
    
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    
    /**
     * @param stackData
     * @param stackMin
     */
    public GetMinStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }
    
    public void push(int i) {
        stackData.push(i);
        if (stackMin.size() > 0 && i <= stackMin.peek())
            stackMin.push(i);
        else if (stackMin.size() == 0)
            stackMin.push(i);
    }
    
    public int pop() {
        if (stackData.size() <= 0)
            return 0;
        int i = this.stackData.pop();
        if (i == this.stackMin.peek()) {
            this.stackMin.pop();
        }
        return i;
    }
    
    public int getMin() {
        if (this.stackData.size() > 0) {
            return this.stackMin.peek();
        }
        return 0;
    }
    
    @Test
    public void test1() {
        GetMinStack minStack = new GetMinStack();
        minStack.push(3);
        System.out.println("Now the Min : " + minStack.getMin());
        minStack.push(2);
        System.out.println("Now the Min : " + minStack.getMin());
        minStack.push(4);
        minStack.push(5);
        minStack.push(1);
        System.out.println("Now the Min : " + minStack.getMin());
        System.out.println("Pop : " + minStack.pop());
        System.out.println("Now the Min : " + minStack.getMin());
        System.out.println("Pop : " + minStack.pop());
        System.out.println("Now the Min : " + minStack.getMin());
        minStack.push(2);
        minStack.push(1);
        System.out.println("Now the Min : " + minStack.getMin());
    }
}
