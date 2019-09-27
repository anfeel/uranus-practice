package dataStructure.linkedlist;

import org.junit.Test;

/**
 * 在单链表和双链表中删除倒数第k个节点
 * 实现两个函数，分别在单链表和双链表中删除
 * @author prd-fuy
 * @version $Id: DeleteBackKth.java, v 0.1 2019年8月21日 上午11:16:06 prd-fuy Exp $
 */
public class DeleteBackKth {
    
    public void deleteBackKthListNode(ListNode pHead, int k) {
        int len = 0;
        ListNode cur = pHead;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        if (k > len)
            throw new RuntimeException();
        int i = 1;
        while (i <= len - k - 1) {
            pHead = pHead.next;
            i++;
        }
        ListNode pCur = pHead.next;
        pHead.next = pCur.next;
        pCur.next = null;
    }
    
    public void deleteBackKthDoubleListNode(DoubleListNode pHead, int k) {
        if (pHead == null || (pHead.next == null && k > 1))
            return;
        int len = 1;
        DoubleListNode cur = pHead;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        if (k > len)
            throw new RuntimeException(" k is bigger than length");
        if (k == 1)
            cur.last.next = null;
        else {
            DoubleListNode pre = null;
            while (--k > 0) {
                pre = cur;
                cur = cur.last;
            }
            cur.last.next = pre;
            pre.last = cur.last;
        }
    }
    
    @Test
    public void test1() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(4);
        p1_2.next = p1_3;
        ListNode p1_4 = new ListNode(5);
        p1_3.next = p1_4;
        ListNode p1_5 = new ListNode(3);
        p1_4.next = p1_5;
        ListNode p1_6 = new ListNode(8);
        p1_5.next = p1_6;
        ListNode p1_7 = new ListNode(9);
        p1_6.next = p1_7;
        ListNode p1_8 = new ListNode(7);
        p1_7.next = p1_8;
        ListNode.printLinkedList(p1_1);
        deleteBackKthListNode(p1_1, 3);
        System.out.println("after deletion .....");
        ListNode.printLinkedList(p1_1);
    }
    
    @Test
    public void test2() {
        DoubleListNode p1_1 = new DoubleListNode(1);
        DoubleListNode p1_2 = new DoubleListNode(2);
        p1_1.next = p1_2;
        p1_2.last = p1_1;
        DoubleListNode p1_3 = new DoubleListNode(4);
        p1_2.next = p1_3;
        p1_3.last = p1_2;
        DoubleListNode p1_4 = new DoubleListNode(5);
        p1_3.next = p1_4;
        p1_4.last = p1_3;
        DoubleListNode p1_5 = new DoubleListNode(3);
        p1_4.next = p1_5;
        p1_5.last = p1_4;
        DoubleListNode p1_6 = new DoubleListNode(8);
        p1_5.next = p1_6;
        p1_6.last = p1_5;
        DoubleListNode p1_7 = new DoubleListNode(9);
        p1_6.next = p1_7;
        p1_7.last = p1_6;
        DoubleListNode p1_8 = new DoubleListNode(7);
        p1_7.next = p1_8;
        p1_8.last = p1_7;
        DoubleListNode.printDoubleLinkedList(p1_1);
        deleteBackKthDoubleListNode(p1_1, 3);
        System.out.println("\nafter deletion .....");
        DoubleListNode.printDoubleLinkedList(p1_1);
    }
    
}
