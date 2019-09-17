package org.szfs.basic.web.demo.test.dataStruture;

/**
 * 一种消息接收并打印的结构设计
 * <p>消息流吐出2，结构接收而不打印2，因为1还没出现</p>
 * <p>消息流吐出1，结构接收1，并且打印1，2</p>
 * <p>消息流吐出4，结构接收而不打印4，因为3还没出现</p>
 * <p>消息流吐出5，结构接收而不打印5，因为3还没出现</p>
 * <p>消息流吐出7，结构接收而不打印7，因为3还没出现</p>
 * <p>消息流吐出3，结构接收3，并且打印3，4，5</p>
 * <p>消息流吐出9，结构接收而不打印9，因为6还没出现</p>
 * <p>消息流吐出8，结构接收而不打印8，因为6还没出现</p>
 * <p>消息流吐出6，结构接收6，并且打印6，7，8，9</p>
 * <p>已知一个消息流会不断的吐出整数1~N，但不一定按照顺序吐出。
 * 如果上次打印的数为，那么当i+1出现时，请打印i+1及其之后接收过的并且连续的所有数，知道1~N全部接收并打印完</p>
 * <p>要求：消息流最终会吐出全部的1~N，当然最终也会打印完所有的1~N，时间复杂度O(N)</p>
 * @author prd-fuy
 * @version $Id: MessageQueue.java, v 0.1 2019年9月17日 上午10:28:27 prd-fuy Exp $
 */
public class MessageQueue {
    
    private int[] array;
    
    private int   cur;
    
    public MessageQueue(int size) {
        this.array = new int[size + 1];
        this.cur = 1;
    }
    
    public void receive(int message) {
        array[message] = 1;
        if (message == cur) {
            System.out.print("receive " + message + " print : ");
            print();
        } else {
            System.out.println("receive " + message + " . cannot print , coz " + cur + " has not received");
        }
    }
    
    public void print() {
        while (array[cur] == 1) {
            System.out.printf(" %d ", cur);
            cur++;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        MessageQueue box = new MessageQueue(20);
        box.receive(2);
        box.receive(1);
        box.receive(4);
        box.receive(5);
        box.receive(7);
        box.receive(3);
        box.receive(9);
        box.receive(8);
        box.receive(6);
    }
}
