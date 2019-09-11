package org.szfs.basic.web.demo.test.linkedlist;

import org.junit.Test;

/**
 * 反转单向和双向链表
 * 反转双向链表需考虑到：在结束遍历时，要修改当前节点的last指向，不然会造成循环指向
 * @author prd-fuy
 * @version $Id: ReverseLinkedList.java, v 0.1 2019年8月21日 下午2:58:12 prd-fuy Exp $
 */
public class ReverseLinkedList {
    class Node {
        public int  value;
        public Node next;
        
        public Node(int data) {
            this.value = data;
        }
    }
    
    class DoubleNode {
        public int        value;
        public DoubleNode last;
        public DoubleNode next;
        
        public DoubleNode(int data) {
            this.value = data;
        }
    }
    
    public void printLinkedList(Node pHead) {
        while (pHead != null) {
            System.out.println("node -> " + pHead.value);
            pHead = pHead.next;
        }
    }
    
    public void printDoubleLinkedList(DoubleNode pHead) {
        while (pHead != null) {
            System.out.println("positive order : node -> " + pHead.value);
            if (pHead.next == null)
                break;
            pHead = pHead.next;
        }
        System.out.println("begin from the end of list.....");
        while (pHead != null) {
            System.out.println("negative order :node -> " + pHead.value);
            if (pHead.last == null)
                break;
            pHead = pHead.last;
        }
    }
    
    public Node reverseNode(Node head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        Node cur = new Node(0);
        Node tmp = new Node(0);
        if (head.next != null) {
            cur.next = head.next;
            head.next = null;
        }
        while (cur.next.next != null) {
            tmp.next = cur.next.next;
            cur.next.next = head;
            head = cur.next;
            cur.next = tmp.next;
        }
        cur.next.next = head;
        return cur.next;
    }
    
    /**
     * 问题不能想复杂了
     * @param head
     * @return
     */
    public Node reverseNode2(Node head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        Node pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    public DoubleNode reverseDoubleNode(DoubleNode head) {
        if (head == null)
            return null;
        //若头结点没有next节点，则直接返回头结点
        if (head.next == null)
            return head;
        DoubleNode cur = new DoubleNode(0);
        DoubleNode tmp = new DoubleNode(0);
        //若头结点有next节点，先获得头结点的next，再修改头结点的next和last指向
        if (head.next != null) {
            cur.next = head.next;
            head.next = null;
            head.last = cur.next;
        }
        //若当前节点(cur.next)的next不为空，则继续遍历
        while (cur.next.next != null) {
            //获得当前节点的下一节点
            tmp.next = cur.next.next;
            //将当前节点的last指向下一节点
            cur.next.last = tmp.next;
            //将当前节点的next指向前一节点
            cur.next.next = head;
            //当前节点已完成指向修改，将当前节点保存为head，作为下次遍历当前节点的前一节点
            head = cur.next;
            //将当前节点的下一节点保存为当前节点
            cur.next = tmp.next;
        }
        //若当前节点(cur.next)的next为空，则将前一节点的last指向当前节点
        head.last = cur.next;
        //将当前节点的next指向前一节点
        cur.next.next = head;
        //因当前节点是链表尾节点，将当前节点的last指空
        cur.next.last = null;
        return cur.next;
    }
    
    public DoubleNode reverseDoubleNode2(DoubleNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        DoubleNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    @Test
    public void test1() {
        Node p1_1 = new Node(1);
        Node p1_2 = new Node(2);
        p1_1.next = p1_2;
        Node p1_3 = new Node(3);
        p1_2.next = p1_3;
        Node p1_4 = new Node(4);
        p1_3.next = p1_4;
        Node p1_5 = new Node(5);
        p1_4.next = p1_5;
        System.out.println("before reverse....");
        printLinkedList(p1_1);
        Node node = reverseNode2(p1_1);
        System.out.println("after reverse....");
        printLinkedList(node);
    }
    
    @Test
    public void test2() {
        DoubleNode p1_1 = new DoubleNode(1);
        DoubleNode p1_2 = new DoubleNode(2);
        p1_1.next = p1_2;
        p1_2.last = p1_1;
        DoubleNode p1_3 = new DoubleNode(3);
        p1_2.next = p1_3;
        p1_3.last = p1_2;
        DoubleNode p1_4 = new DoubleNode(4);
        p1_3.next = p1_4;
        p1_4.last = p1_3;
        DoubleNode p1_5 = new DoubleNode(5);
        p1_4.next = p1_5;
        p1_5.last = p1_4;
        System.out.println("before reverse....");
        printDoubleLinkedList(p1_1);
        DoubleNode node = reverseDoubleNode2(p1_1);
        System.out.println("after reverse....");
        printDoubleLinkedList(node);
    }
}
