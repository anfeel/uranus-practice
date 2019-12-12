package dataStructure.linkedlist;

import org.junit.Test;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

    示例：
    
    给定一个链表: 1->2->3->4->5, 和 n = 2.
    
    当删除了倒数第二个节点后，链表变为 1->2->3->5.
    说明：
    
    给定的 n 保证是有效的。
    
    进阶：
    
    你能尝试使用一趟扫描实现吗？
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: RemoveNthFromEnd.java, v 0.1 2019年12月12日 下午2:05:24 anfeel Exp $
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode last = new ListNode(0), p = head;
        last.next = head;
        int len = 0;
        while (head != null) {
            len++;
            if (len > n)
                last = last.next;
            head = head.next;
        }
        last.next = last.next.next;
        if (len == n)
            return last.next;
        return p;
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
        ListNode res = removeNthFromEnd(p1_1, 2);
        System.out.println("first node = " + (res == null ? -1 : res.val) + " , after deletion .....");
        ListNode.printLinkedList(res);
    }

    @Test
    public void test2() {
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
        ListNode res = removeNthFromEnd(null, 11);
        System.out.println("first node = " + (res == null ? -1 : res.val) + " , after deletion .....");
        ListNode.printLinkedList(p1_1);
    }

    @Test
    public void test3() {
        ListNode p1_1 = new ListNode(1);
        ListNode.printLinkedList(p1_1);
        ListNode res = removeNthFromEnd(p1_1, 1);
        System.out.println("first node = " + (res == null ? -1 : res.val) + " , after deletion .....");
        ListNode.printLinkedList(res);
    }

    @Test
    public void test4() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode.printLinkedList(p1_1);
        ListNode res = removeNthFromEnd(p1_1, 1);
        System.out.println("first node = " + (res == null ? -1 : res.val) + " , after deletion .....");
        ListNode.printLinkedList(res);
    }

    @Test
    public void test5() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode.printLinkedList(p1_1);
        ListNode res = removeNthFromEnd(p1_1, 2);
        System.out.println("first node = " + (res == null ? -1 : res.val) + " , after deletion .....");
        ListNode.printLinkedList(res);
    }
}
