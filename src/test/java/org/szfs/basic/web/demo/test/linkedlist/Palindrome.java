package org.szfs.basic.web.demo.test.linkedlist;

import java.util.Stack;

import org.junit.Test;

/**
 * 判断一个链表是否为回文结构
 * 例如：
 * 1->2->1 ，返回true
 * 1->2->2->1 ，返回true
 * 15->6->15 ，返回true
 * 1->2->3 ，返回false
 * 普通解法：用一个栈存入后半段节点，再依次弹出与前半段节点比较
 * 进阶解法：？
 * @author prd-fuy
 * @version $Id: Palindrome.java, v 0.1 2019年9月25日 下午4:19:50 prd-fuy Exp $
 */
public class Palindrome {
    class Node {
        public int  value;
        public Node next;
        
        public Node(int data) {
            this.value = data;
        }
    }
    
    public boolean palindrome(Node head) {
        if (head == null || head.next == null)
            return false;
        int len = 0;
        Stack<Node> stack1 = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack1.push(cur);
            cur = cur.next;
            len++;
        }
        int j = len;
        while (!stack1.isEmpty()) {
            if (len % 2 == 1) {
                while (j > (len + 1) / 2) {
                    if (head.value != stack1.pop().value)
                        return false;
                    head = head.next;
                    j--;
                }
            } else {
                while (j > len / 2) {
                    if (head.value != stack1.pop().value)
                        return false;
                    head = head.next;
                    j--;
                }
            }
            return true;
        }
        return false;
    }
    
    public void printLinkedList(Node pHead) {
        while (pHead != null) {
            System.out.print(pHead.value + " -> ");
            pHead = pHead.next;
        }
        System.out.println();
    }
    
    @Test
    public void test1() {
        Node p1_1 = new Node(1);
        Node p1_2 = new Node(2);
        p1_1.next = p1_2;
        Node p1_3 = new Node(3);
        p1_2.next = p1_3;
        Node p1_4 = new Node(2);
        p1_3.next = p1_4;
        Node p1_5 = new Node(1);
        p1_4.next = p1_5;
        printLinkedList(p1_1);
        boolean b = palindrome(p1_1);
        System.out.println(" palindrome ?  " + b);
    }
    
    @Test
    public void test2() {
        Node p1_1 = new Node(1);
        Node p1_2 = new Node(2);
        p1_1.next = p1_2;
        Node p1_3 = new Node(3);
        p1_2.next = p1_3;
        Node p1_4 = new Node(4);
        p1_3.next = p1_4;
        Node p1_5 = new Node(5);
        p1_4.next = p1_5;
        printLinkedList(p1_1);
        boolean b = palindrome(p1_1);
        System.out.println(" palindrome ?  " + b);
    }
    
    @Test
    public void test3() {
        Node p1_1 = new Node(1);
        Node p1_2 = new Node(2);
        p1_1.next = p1_2;
        Node p1_3 = new Node(3);
        p1_2.next = p1_3;
        Node p1_4 = new Node(4);
        p1_3.next = p1_4;
        Node p1_5 = new Node(5);
        p1_4.next = p1_5;
        Node p1_6 = new Node(6);
        p1_5.next = p1_6;
        printLinkedList(p1_1);
        boolean b = palindrome(p1_1);
        System.out.println(" palindrome ?  " + b);
    }
    
    @Test
    public void test4() {
        Node p1_1 = new Node(1);
        Node p1_2 = new Node(2);
        p1_1.next = p1_2;
        Node p1_3 = new Node(3);
        p1_2.next = p1_3;
        Node p1_4 = new Node(3);
        p1_3.next = p1_4;
        Node p1_5 = new Node(2);
        p1_4.next = p1_5;
        Node p1_6 = new Node(1);
        p1_5.next = p1_6;
        printLinkedList(p1_1);
        boolean b = palindrome(p1_1);
        System.out.println(" palindrome ?  " + b);
    }
}
