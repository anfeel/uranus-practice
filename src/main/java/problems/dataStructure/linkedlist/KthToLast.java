package problems.dataStructure.linkedlist;

import org.junit.Test;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $ Id:KthToLast, v 0.1 2020年07月13日 15:15 anfeel Exp $
 */
public class KthToLast {
    public int kthToLast(ListNode head, int k) {
        if (k <= 0)
            return 0;
        ListNode p = head;
        int c = 1;
        while (head.next != null) {
            head = head.next;
            c++;
            if (c >= k + 1)
                p = p.next;
        }
        if (c < k)
            return 0;
        return p.val;
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
        System.out.println(kthToLast(p1_1, 10));
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
        System.out.println(kthToLast(p1_1, 3));
    }

    @Test
    public void test3() {
        ListNode p1_1 = new ListNode(1);
        System.out.println(kthToLast(p1_1, 1));
    }


}
