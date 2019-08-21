package org.szfs.basic.web.demo.test.dataStruture;

import org.junit.Test;

/**
 * 打印两个有序链表的公共部分
 * @author prd-fuy
 * @version $Id: PrintCommonPart.java, v 0.1 2019年8月21日 上午10:38:19 prd-fuy Exp $
 */
public class PrintCommonPart {
    class Node {
        public int  value;
        public Node next;
        
        public Node(int data) {
            this.value = data;
        }
    }
    
    public void print(Node pHead1, Node pHead2) {
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.value < pHead2.value) {
                pHead1 = pHead1.next;
            } else if (pHead1.value > pHead2.value) {
                pHead2 = pHead2.next;
            } else {
                System.out.println("common part : p1->" + pHead1.value + " , p2->" + pHead2.value);
                pHead2 = pHead2.next;
                pHead1 = pHead1.next;
            }
        }
    }
    
    @Test
    public void test1() {
        Node p1_1 = new Node(1);
        Node p1_2 = new Node(2);
        p1_1.next = p1_2;
        Node p1_3 = new Node(4);
        p1_2.next = p1_3;
        Node p1_4 = new Node(5);
        p1_3.next = p1_4;
        Node p1_5 = new Node(6);
        p1_4.next = p1_5;
        
        Node p2_1 = new Node(9);
        Node p2_2 = new Node(11);
        p2_1.next = p2_2;
        Node p2_3 = new Node(12);
        p2_2.next = p2_3;
        Node p2_4 = new Node(123);
        p2_3.next = p2_4;
        Node p2_5 = new Node(133);
        p2_4.next = p2_5;
        
        print(p1_1, p2_1);
    }
}
