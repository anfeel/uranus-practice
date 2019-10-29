package dataStructure.linkedlist;

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
    
    public boolean palindrome(ListNode head) {
        if (head == null || head.next == null)
            return false;
        int len = 0;
        Stack<ListNode> stack1 = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack1.push(cur);
            cur = cur.next;
            len++;
        }
        int j = len;
        while (!stack1.isEmpty()) {
            if (len % 2 == 1) {
                while (j > (len + 1) / 2) {
                    if (head.val != stack1.pop().val)
                        return false;
                    head = head.next;
                    j--;
                }
            } else {
                while (j > len / 2) {
                    if (head.val != stack1.pop().val)
                        return false;
                    head = head.next;
                    j--;
                }
            }
            return true;
        }
        return false;
    }
    
    @Test
    public void test1() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;
        ListNode p1_4 = new ListNode(2);
        p1_3.next = p1_4;
        ListNode p1_5 = new ListNode(1);
        p1_4.next = p1_5;
        ListNode.printLinkedList(p1_1);
        boolean b = palindrome(p1_1);
        System.out.println(" palindrome ?  " + b);
    }
    
    @Test
    public void test2() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;
        ListNode p1_4 = new ListNode(4);
        p1_3.next = p1_4;
        ListNode p1_5 = new ListNode(5);
        p1_4.next = p1_5;
        ListNode.printLinkedList(p1_1);
        boolean b = palindrome(p1_1);
        System.out.println(" palindrome ?  " + b);
    }
    
    @Test
    public void test3() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;
        ListNode p1_4 = new ListNode(4);
        p1_3.next = p1_4;
        ListNode p1_5 = new ListNode(5);
        p1_4.next = p1_5;
        ListNode p1_6 = new ListNode(6);
        p1_5.next = p1_6;
        ListNode.printLinkedList(p1_1);
        boolean b = palindrome(p1_1);
        System.out.println(" palindrome ?  " + b);
    }
    
    @Test
    public void test4() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;
        ListNode p1_4 = new ListNode(3);
        p1_3.next = p1_4;
        ListNode p1_5 = new ListNode(2);
        p1_4.next = p1_5;
        ListNode p1_6 = new ListNode(1);
        p1_5.next = p1_6;
        ListNode.printLinkedList(p1_1);
        boolean b = palindrome(p1_1);
        System.out.println(" palindrome ?  " + b);
    }
}
