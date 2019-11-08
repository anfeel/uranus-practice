package design;

import java.util.Stack;

import org.junit.Test;

/**
 * 用两个栈实现队列
 * 思路1：用a栈按入队顺序保存元素
 * 当需要出队时，检查b栈是否为空，
 * 若b栈不为空，则b栈元素序列为当前出队序列
 * 若b栈为空，则将a栈所有元素pop至b栈，b栈元素序列即为出队序列
 * @author prd-fuy
 * @version $Id: TwoStacksQueue.java, v 0.1 2019年8月16日 下午4:33:19 prd-fuy Exp $
 */
public class TwoStacksQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public TwoStacksQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }
    
    public void add(int i) {
        stack1.push(i);
    }
    
    public int poll() {
        if (stack1.empty() && stack2.empty())
            throw new RuntimeException("queue is empty");
        else if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    public int peek() {
        if (stack1.empty() && stack2.empty())
            throw new RuntimeException("queue is empty");
        else if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    @Test
    public void test() {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.add(2);
        queue.add(3);
        queue.add(1);
        queue.add(5);
        System.out.println("poll :" + queue.poll());
        System.out.println("poll :" + queue.poll());
        System.out.println("poll :" + queue.poll());
        queue.add(4);
        queue.add(0);
        queue.add(6);
        System.out.println("poll :" + queue.poll());
        System.out.println("poll :" + queue.poll());
    }
}
