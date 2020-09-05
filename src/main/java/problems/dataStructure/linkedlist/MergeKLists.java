package problems.dataStructure.linkedlist;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:MergeKLists, v 0.1 2020年09月03日 12:01 anfeel Exp $
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        int count = 0;
        ListNode head = new ListNode(0), root = head;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.add(lists[i]);
        }
        while (count < lists.length) {
            ListNode cur = pq.poll();
            if (cur != null) {
                ListNode next = cur.next;
                if (next != null)
                    pq.add(next);
                else
                    count++;
                head.next = cur;
                head = head.next;
            } else
                count++;

        }
        return root.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        int count = 0;
        ListNode head = new ListNode(0), root = head;
        while (count < lists.length) {
            for (int i = 0; i < lists.length; i++) {
                ListNode cur = lists[i];
                if (cur != null) {
                    if (pq.size() == lists.length && cur.val < pq.peek().val) {
                        head.next = cur;
                        head = head.next;
                        lists[i] = lists[i].next;
                        i--;
                    } else {
                        if (pq.size() >= lists.length) {
                            head.next = pq.poll();
                            head = head.next;
                        }
                        pq.add(cur);
                        lists[i] = lists[i].next;
                    }
                } else
                    count++;
            }
            if (count == lists.length)
                break;
            count = 0;
        }
        while (!pq.isEmpty()) {
            head.next = pq.poll();
            head = head.next;
        }

        return root.next;
    }

    /**
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     */
    @Test
    public void test1() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(4);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(5);
        p1_2.next = p1_3;

        ListNode p2_1 = new ListNode(1);
        ListNode p2_2 = new ListNode(3);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(4);
        p2_2.next = p2_3;

        ListNode p3_1 = new ListNode(2);
        ListNode p3_2 = new ListNode(6);
        p3_1.next = p3_2;

        ListNode[] lists = new ListNode[]{p1_1, p2_1, p3_1};
        ListNode res = mergeKLists(lists);
        ListNode.printLinkedList(res);
    }

    @Test
    public void test2() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(4);
        ListNode p1_3 = new ListNode(5);
        p1_1.next = p1_2;
        p1_2.next = p1_3;

        ListNode p2_1 = new ListNode(1);
        ListNode p2_2 = new ListNode(3);
        ListNode p2_3 = new ListNode(4);
        p2_1.next = p2_2;
        p2_2.next = p2_3;

        ListNode p3_1 = new ListNode(2);
        ListNode p3_2 = new ListNode(6);
        p3_1.next = p3_2;

        ListNode p4_1 = new ListNode(2);
        ListNode p4_2 = new ListNode(6);
        ListNode p4_3 = new ListNode(8);
        ListNode p4_4 = new ListNode(9);
        p4_1.next = p4_2;
        p4_2.next = p4_3;
        p4_3.next = p4_4;

        ListNode[] lists = new ListNode[]{p1_1, p2_1, p3_1, p4_1};
        ListNode res = mergeKLists(lists);
        ListNode.printLinkedList(res);
    }

    @Test
    public void test3() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(4);
        ListNode p1_3 = new ListNode(5);
        p1_1.next = p1_2;
        p1_2.next = p1_3;

        ListNode p2_1 = new ListNode(1);
        ListNode p2_2 = new ListNode(3);
        ListNode p2_3 = new ListNode(4);
        p2_1.next = p2_2;
        p2_2.next = p2_3;

        ListNode p3_1 = new ListNode(2);
        ListNode p3_2 = new ListNode(6);
        p3_1.next = p3_2;

        ListNode p4_1 = new ListNode(2);
        ListNode p4_2 = new ListNode(6);
        ListNode p4_3 = new ListNode(8);
        ListNode p4_4 = new ListNode(9);
        p4_1.next = p4_2;
        p4_2.next = p4_3;
        p4_3.next = p4_4;

        ListNode[] lists = new ListNode[]{p1_1, p2_1, null, p4_1};
        ListNode res = mergeKLists(lists);
        ListNode.printLinkedList(res);
    }

    @Test
    public void test4() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(4);
        ListNode p1_3 = new ListNode(5);
        p1_1.next = p1_2;
        p1_2.next = p1_3;

        ListNode p2_1 = new ListNode(1);
        ListNode p2_2 = new ListNode(3);
        ListNode p2_3 = new ListNode(4);
        p2_1.next = p2_2;
        p2_2.next = p2_3;

        ListNode p3_1 = null;

        ListNode p4_1 = new ListNode(2);
        ListNode p4_2 = new ListNode(6);
        ListNode p4_3 = new ListNode(8);
        ListNode p4_4 = new ListNode(9);
        p4_1.next = p4_2;
        p4_2.next = p4_3;
        p4_3.next = p4_4;

        ListNode[] lists = new ListNode[]{p1_1, p2_1, p3_1, p4_1};
        ListNode res = mergeKLists(lists);
        ListNode.printLinkedList(res);
    }

    @Test
    public void test5() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(4);
        ListNode p1_3 = new ListNode(5);
        p1_1.next = p1_2;
        p1_2.next = p1_3;

        ListNode p2_1 = new ListNode(1);
        ListNode p2_2 = new ListNode(3);
        ListNode p2_3 = new ListNode(4);
        p2_1.next = p2_2;
        p2_2.next = p2_3;

        ListNode p3_1 = null;

        ListNode p4_1 = new ListNode(2);
        ListNode p4_2 = new ListNode(6);
        ListNode p4_3 = new ListNode(8);
        ListNode p4_4 = new ListNode(9);
        p4_1.next = p4_2;
        p4_2.next = p4_3;
        p4_3.next = p4_4;

        ListNode[] lists = new ListNode[]{null, null, null, null};
        ListNode res = mergeKLists(lists);
        ListNode.printLinkedList(res);
    }

    @Test
    public void test6() {
        ListNode[] lists = null;
        ListNode res = mergeKLists(lists);
        ListNode.printLinkedList(res);
    }

    @Test
    public void test7() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;

        ListNode p4_1 = new ListNode(4);
        ListNode p4_2 = new ListNode(5);
        ListNode p4_3 = new ListNode(6);
        ListNode p4_4 = new ListNode(7);
        p4_1.next = p4_2;
        p4_2.next = p4_3;
        p4_3.next = p4_4;

        ListNode[] lists = new ListNode[]{p1_1, p4_1};
        ListNode res = mergeKLists(lists);
        ListNode.printLinkedList(res);
    }

    @Test
    public void test8() {

        ListNode p2_1 = new ListNode(-1);
        ListNode p2_2 = new ListNode(5);
        ListNode p2_3 = new ListNode(11);
        p2_1.next = p2_2;
        p2_2.next = p2_3;


        ListNode p4_1 = new ListNode(6);
        ListNode p4_2 = new ListNode(10);
        p4_1.next = p4_2;

        ListNode[] lists = new ListNode[]{null, p2_1, null, p4_1};
        ListNode res = mergeKLists(lists);
        ListNode.printLinkedList(res);
    }

    @Test
    public void test9() {
        ListNode p1_1 = new ListNode(-10);
        ListNode p1_2 = new ListNode(-9);
        ListNode p1_3 = new ListNode(-9);
        ListNode p1_4 = new ListNode(-9);
        ListNode p1_5 = new ListNode(-7);
        ListNode p1_6 = new ListNode(-2);
        ListNode p1_7 = new ListNode(1);
        ListNode p1_8 = new ListNode(2);
        ListNode p1_9 = new ListNode(4);
        p1_1.next = p1_2;
        p1_2.next = p1_3;
        p1_3.next = p1_4;
        p1_4.next = p1_5;
        p1_5.next = p1_6;
        p1_6.next = p1_7;
        p1_7.next = p1_8;
        p1_8.next = p1_9;

        ListNode p2_1 = new ListNode(-9);
        ListNode p2_2 = new ListNode(-7);
        ListNode p2_3 = new ListNode(-6);
        ListNode p2_4 = new ListNode(-6);
        ListNode p2_5 = new ListNode(-3);
        ListNode p2_6 = new ListNode(0);
        ListNode p2_7 = new ListNode(1);
        ListNode p2_8 = new ListNode(3);
        p2_1.next = p2_2;
        p2_2.next = p2_3;
        p2_3.next = p2_4;
        p2_4.next = p2_5;
        p2_5.next = p2_6;
        p2_6.next = p2_7;
        p2_7.next = p2_8;

        ListNode p3_1 = new ListNode(-10);
        ListNode p3_2 = new ListNode(-9);
        ListNode p3_3 = new ListNode(-2);
        ListNode p3_4 = new ListNode(-1);
        ListNode p3_5 = new ListNode(1);
        ListNode p3_6 = new ListNode(3);
        p3_1.next = p3_2;
        p3_2.next = p3_3;
        p3_3.next = p3_4;
        p3_4.next = p3_5;
        p3_5.next = p3_6;

        ListNode[] lists = new ListNode[]{p1_1, p2_1, p3_1};
        ListNode res = mergeKLists(lists);
        ListNode.printLinkedList(res);
    }

    /**
     * [[-8,-7,-6,-3,-2,-2,0,3],[-10,-6,-4,-4,-4,-2,-1,4],[-10,-9,-8,-8,-6],[-10,0,4]]
     */
    @Test
    public void testa() {
        ListNode p1_1 = new ListNode(-8);
        ListNode p1_2 = new ListNode(-7);
        ListNode p1_3 = new ListNode(-6);
        ListNode p1_4 = new ListNode(-3);
        ListNode p1_5 = new ListNode(-2);
        ListNode p1_6 = new ListNode(-2);
        ListNode p1_7 = new ListNode(0);
        ListNode p1_8 = new ListNode(3);
        p1_1.next = p1_2;
        p1_2.next = p1_3;
        p1_3.next = p1_4;
        p1_4.next = p1_5;
        p1_5.next = p1_6;
        p1_6.next = p1_7;
        p1_7.next = p1_8;

        ListNode p2_1 = new ListNode(-10);
        ListNode p2_2 = new ListNode(-6);
        ListNode p2_3 = new ListNode(-4);
        ListNode p2_4 = new ListNode(-4);
        ListNode p2_5 = new ListNode(-4);
        ListNode p2_6 = new ListNode(2);
        ListNode p2_7 = new ListNode(1);
        ListNode p2_8 = new ListNode(4);
        p2_1.next = p2_2;
        p2_2.next = p2_3;
        p2_3.next = p2_4;
        p2_4.next = p2_5;
        p2_5.next = p2_6;
        p2_6.next = p2_7;
        p2_7.next = p2_8;

        ListNode p3_1 = new ListNode(-10);
        ListNode p3_2 = new ListNode(-9);
        ListNode p3_3 = new ListNode(-8);
        ListNode p3_4 = new ListNode(-8);
        ListNode p3_5 = new ListNode(6);
        p3_1.next = p3_2;
        p3_2.next = p3_3;
        p3_3.next = p3_4;
        p3_4.next = p3_5;

        ListNode p4_1 = new ListNode(-10);
        ListNode p4_2 = new ListNode(0);
        ListNode p4_3 = new ListNode(4);
        p4_1.next = p4_2;
        p4_2.next = p4_3;

        ListNode[] lists = new ListNode[]{p1_1, p2_1, p3_1, p4_1};
        ListNode res = mergeKLists(lists);
        ListNode.printLinkedList(res);
    }
}
