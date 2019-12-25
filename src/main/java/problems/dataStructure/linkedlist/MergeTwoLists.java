package problems.dataStructure.linkedlist;

import org.junit.Test;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.

    Example:
    
    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: MergeTwoLists.java, v 0.1 2019年12月25日 下午1:47:04 anfeel Exp $
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode last = new ListNode(0);
        ListNode cur = last;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return last.next;
    }

    @Test
    public void test1() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;
        ListNode p1_4 = new ListNode(5);
        p1_3.next = p1_4;
        ListNode p1_5 = new ListNode(7);
        p1_4.next = p1_5;

        ListNode p2_1 = new ListNode(2);
        ListNode p2_2 = new ListNode(3);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(8);
        p2_2.next = p2_3;

        ListNode.printLinkedList(p1_1);
        ListNode.printLinkedList(p2_1);
        ListNode res = mergeTwoLists(p1_1, p2_1);
        ListNode.printLinkedList(res);

    }

    @Test
    public void test2() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;
        ListNode p1_4 = new ListNode(5);
        p1_3.next = p1_4;
        ListNode p1_5 = new ListNode(7);
        p1_4.next = p1_5;

        ListNode p2_1 = new ListNode(2);
        ListNode p2_2 = new ListNode(3);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(8);
        p2_2.next = p2_3;

        ListNode.printLinkedList(null);
        ListNode.printLinkedList(p2_1);
        ListNode res = mergeTwoLists(null, p2_1);
        ListNode.printLinkedList(res);

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
        ListNode p1_5 = new ListNode(7);
        p1_4.next = p1_5;

        ListNode p2_1 = new ListNode(2);
        ListNode p2_2 = new ListNode(4);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(8);
        p2_2.next = p2_3;

        ListNode.printLinkedList(p1_1);
        ListNode.printLinkedList(p2_1);
        ListNode res = mergeTwoLists(p1_1, p2_1);
        ListNode.printLinkedList(res);

    }

    @Test
    public void test4() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(3);
        p1_1.next = p1_2;
        ListNode p1_5 = new ListNode(4);
        p1_2.next = p1_5;

        ListNode p2_1 = new ListNode(1);
        ListNode p2_2 = new ListNode(2);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(4);
        p2_2.next = p2_3;

        ListNode.printLinkedList(p1_1);
        ListNode.printLinkedList(p2_1);
        ListNode res = mergeTwoLists(p1_1, p2_1);
        ListNode.printLinkedList(res);

    }

}
