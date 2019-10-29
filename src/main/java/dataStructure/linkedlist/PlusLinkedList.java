package dataStructure.linkedlist;

import java.util.Stack;

import org.junit.Test;

/**
 * 两个单链表生成相加链表
 * 假设链表中每一个节点的值都在0~9之间，那么链表整体就可以代表一个整数
 * 例如9->3->7，可以代表整数937
 * 例如链表1为9->3->7，链表2为6->3，最后生成新的结果链表为1->0->0->0
 * 1.栈结构解法
 * @author prd-fuy
 * @version $Id: PlusLinkedList.java, v 0.1 2019年9月11日 上午9:21:42 prd-fuy Exp $
 */
public class PlusLinkedList {
    
    public ListNode plusLinkedList(ListNode head1, ListNode head2) {
        
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.add(head2);
            head2 = head2.next;
        }
        int carry = 0;
        ListNode last = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int num2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            int num = num1 + num2 + carry;
            if (num >= 10) {
                num %= 10;
                carry = 1;
            } else
                carry = 0;
            ListNode node = new ListNode(num);
            node.next = last;
            last = node;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = last;
            last = node;
        }
        return last;
    }
    
    @Test
    public void test1() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;
        
        ListNode p2_1 = new ListNode(9);
        ListNode p2_2 = new ListNode(8);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(8);
        p2_2.next = p2_3;
        
        System.out.println("first linkedlist:");
        ListNode.printLinkedList(p1_1);
        System.out.println("second linkedlist:");
        ListNode.printLinkedList(p2_1);
        
        ListNode result = plusLinkedList(p1_1, p2_1);
        System.out.println("result:");
        ListNode.printLinkedList(result);
        
    }
    
    @Test
    public void test2() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;
        
        ListNode p2_1 = new ListNode(9);
        ListNode p2_2 = new ListNode(8);
        p2_1.next = p2_2;
        
        System.out.println("first linkedlist:");
        ListNode.printLinkedList(p1_1);
        System.out.println("second linkedlist:");
        ListNode.printLinkedList(p2_1);
        
        ListNode result = plusLinkedList(p1_1, p2_1);
        System.out.println("result:");
        ListNode.printLinkedList(result);
        
    }
    
}
