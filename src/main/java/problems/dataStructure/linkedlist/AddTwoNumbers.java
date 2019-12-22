package problems.dataStructure.linkedlist;

import org.junit.Test;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    
    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    
    示例：
    
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/add-two-numbers
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: AddTwoNumbers.java, v 0.1 2019年12月11日 上午9:14:01 anfeel Exp $
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0), cur = new ListNode(0);
        int b = 0;
        head.next = cur;
        while (head1 != null || head2 != null || b != 0) {
            int sum = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val) + b;
            if (sum >= 10) {
                b = 1;
                sum = sum % 10;
            } else
                b = 0;
            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
            ListNode p = new ListNode(sum);
            cur.next = p;
            cur = p;
        }
        return head.next.next;
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

        ListNode result = addTwoNumbers(p1_1, p2_1);
        System.out.println("result:");
        ListNode.printLinkedList(result);
    }

    @Test
    public void test2() {
        ListNode p1_1 = new ListNode(3);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(1);
        p1_2.next = p1_3;

        ListNode p2_1 = new ListNode(8);
        ListNode p2_2 = new ListNode(8);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(9);
        p2_2.next = p2_3;

        System.out.println("first linkedlist:");
        ListNode.printLinkedList(p1_1);
        System.out.println("second linkedlist:");
        ListNode.printLinkedList(p2_1);

        ListNode result = addTwoNumbers(p1_1, p2_1);
        System.out.println("result:");
        ListNode.printLinkedList(result);
    }

    @Test
    public void test3() {
        ListNode p1_1 = new ListNode(3);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;

        ListNode p2_1 = new ListNode(8);
        ListNode p2_2 = new ListNode(8);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(9);
        p2_2.next = p2_3;

        System.out.println("first linkedlist:");
        ListNode.printLinkedList(p1_1);
        System.out.println("second linkedlist:");
        ListNode.printLinkedList(p2_1);

        ListNode result = addTwoNumbers(p1_1, p2_1);
        System.out.println("result:");
        ListNode.printLinkedList(result);
    }

    @Test
    public void test4() {
        ListNode p1_1 = new ListNode(2);
        ListNode p1_2 = new ListNode(4);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;

        ListNode p2_1 = new ListNode(5);
        ListNode p2_2 = new ListNode(6);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(4);
        p2_2.next = p2_3;

        System.out.println("first linkedlist:");
        ListNode.printLinkedList(p1_1);
        System.out.println("second linkedlist:");
        ListNode.printLinkedList(p2_1);

        ListNode result = addTwoNumbers(p1_1, p2_1);
        System.out.println("result:");
        ListNode.printLinkedList(result);
    }

    @Test
    public void test5() {
        ListNode p2_1 = new ListNode(5);
        ListNode p2_2 = new ListNode(6);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(4);
        p2_2.next = p2_3;

        System.out.println("first linkedlist:");
        ListNode.printLinkedList(null);
        System.out.println("second linkedlist:");
        ListNode.printLinkedList(p2_1);

        ListNode result = addTwoNumbers(null, p2_1);
        System.out.println("result:");
        ListNode.printLinkedList(result);
    }

    @Test
    public void test8() {
        ListNode p1_1 = new ListNode(9);
        ListNode p1_2 = new ListNode(9);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(9);
        p1_2.next = p1_3;

        ListNode p2_1 = new ListNode(1);

        System.out.println("first linkedlist:");
        ListNode.printLinkedList(p2_1);
        System.out.println("second linkedlist:");
        ListNode.printLinkedList(p1_1);

        ListNode result = addTwoNumbers(p2_1, p1_1);
        System.out.println("result:");
        ListNode.printLinkedList(result);
    }

    @Test
    public void test6() {
        ListNode p2_1 = new ListNode(5);
        ListNode p2_2 = new ListNode(6);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(4);
        p2_2.next = p2_3;

        System.out.println("first linkedlist:");
        ListNode.printLinkedList(p2_1);
        System.out.println("second linkedlist:");
        ListNode.printLinkedList(null);

        ListNode result = addTwoNumbers(p2_1, null);
        System.out.println("result:");
        ListNode.printLinkedList(result);
    }
}
