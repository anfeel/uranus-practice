package problems.dataStructure.linkedlist;

import org.junit.Test;

/**
 * 反转一个单链表。

    示例:
    
    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
    进阶:
    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/reverse-linked-list
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: ReverseList.java, v 0.1 2019年12月18日 下午3:11:35 anfeel Exp $
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head != null) {
            ListNode next = head.next;
            head.next = null;
            while (next != null) {
                ListNode tmp = next.next;
                next.next = head;
                head = next;
                next = tmp;
            }
        }
        return head;
    }

    @Test
    public void test1() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;
        ListNode p1_4 = new ListNode(4);
        p1_3.next = p1_4;
        ListNode p1_5 = new ListNode(5);
        p1_4.next = p1_5;
        System.out.println("before reverse....");
        ListNode.printLinkedList(p1_1);
        ListNode node = reverseList(p1_1);
        System.out.println("after reverse....");
        ListNode.printLinkedList(node);
    }

    @Test
    public void test2() {
        ListNode p1_1 = new ListNode(1);
        System.out.println("before reverse....");
        ListNode.printLinkedList(p1_1);
        ListNode node = reverseList(p1_1);
        System.out.println("after reverse....");
        ListNode.printLinkedList(node);
    }

    @Test
    public void test3() {
        ListNode p1_1 = null;
        System.out.println("before reverse....");
        ListNode.printLinkedList(p1_1);
        ListNode node = reverseList(p1_1);
        System.out.println("after reverse....");
        ListNode.printLinkedList(node);
    }

    @Test
    public void test4() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        System.out.println("before reverse....");
        ListNode.printLinkedList(p1_1);
        ListNode node = reverseList(p1_1);
        System.out.println("after reverse....");
        ListNode.printLinkedList(node);
    }
}
