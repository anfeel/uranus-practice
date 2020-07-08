package problems.dataStructure.linkedlist;

import org.junit.Test;

import java.util.HashMap;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
 * 1.首次遍历用hashmap记录重复节点出现的次数，再次遍历删除出现次数大于1的节点，适用于已排序或未排序的链表
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author prd-fuy
 * @version $Id: deleteDuplicate.java, v 0.1 2019年9月27日 上午10:47:42 prd-fuy Exp $
 */
public class DeleteDuplicateNode {

    public ListNode deleteDuplication2(ListNode head) {
        if (head == null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode cur1 = head;
        while (cur1 != null) {
            if (map.containsKey(cur1.val)) {
                map.put(cur1.val, map.get(cur1.val) + 1);
            } else
                map.put(cur1.val, 1);
            cur1 = cur1.next;
        }
        cur1 = head;
        ListNode cur2 = cur1;
        while (cur2 != null) {
            if (map.containsKey(cur2.val) && map.get(cur2.val) > 1) {
                if (cur2 != head) {
                    cur2 = cur2.next;
                    cur1.next = cur2;
                } else {
                    cur1 = cur1.next;
                    cur2 = cur1;
                    head = cur1;
                }
            } else {
                cur2 = cur2.next;
            }
        }
        return cur1;
    }

    public ListNode deleteDuplication(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = new ListNode(0);
        cur.next = head;
        while (head.next != null) {
            if (head.next.val == head.val)
                head.next = head.next.next;
            else
                head = head.next;
        }
        return cur.next;
    }

    @Test
    public void test1() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(2);
        p1_2.next = p1_3;
        ListNode p1_4 = new ListNode(2);
        p1_3.next = p1_4;
        ListNode p1_5 = new ListNode(3);
        p1_4.next = p1_5;
        ListNode p1_6 = new ListNode(7);
        p1_5.next = p1_6;
        ListNode p1_7 = new ListNode(8);
        p1_6.next = p1_7;
        ListNode p1_8 = new ListNode(9);
        p1_7.next = p1_8;
        ListNode.printLinkedList(p1_1);
        ListNode node = deleteDuplication(p1_1);
        System.out.println("after deletion .....");
        ListNode.printLinkedList(node);
    }

    @Test
    public void test2() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(1);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(1);
        p1_2.next = p1_3;
        ListNode p1_4 = new ListNode(1);
        p1_3.next = p1_4;
        ListNode p1_5 = new ListNode(1);
        p1_4.next = p1_5;
        ListNode p1_6 = new ListNode(1);
        p1_5.next = p1_6;
        ListNode p1_7 = new ListNode(1);
        p1_6.next = p1_7;
        ListNode p1_8 = new ListNode(1);
        p1_7.next = p1_8;
        ListNode.printLinkedList(p1_1);
        ListNode node = deleteDuplication(p1_1);
        System.out.println("after deletion .....");
        ListNode.printLinkedList(node);
    }
}
