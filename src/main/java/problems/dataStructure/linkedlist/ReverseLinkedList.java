package problems.dataStructure.linkedlist;

import org.junit.Test;

/**
 * 反转单向和双向链表
 * 反转双向链表需考虑到：在结束遍历时，要修改当前节点的last指向，不然会造成循环指向
 * @author prd-fuy
 * @version $Id: ReverseLinkedList.java, v 0.1 2019年8月21日 下午2:58:12 prd-fuy Exp $
 */
public class ReverseLinkedList {
    
    public ListNode reverseNode(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode cur = new ListNode(0);
        ListNode tmp = new ListNode(0);
        if (head.next != null) {
            cur.next = head.next;
            head.next = null;
        }
        while (cur.next.next != null) {
            tmp.next = cur.next.next;
            cur.next.next = head;
            head = cur.next;
            cur.next = tmp.next;
        }
        cur.next.next = head;
        return cur.next;
    }
    
    /**
     * 问题不能想复杂了
     * @param head
     * @return
     */
    public ListNode reverseNode2(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    public DoubleListNode reverseDoubleListNode(DoubleListNode head) {
        if (head == null)
            return null;
        //若头结点没有next节点，则直接返回头结点
        if (head.next == null)
            return head;
        DoubleListNode cur = new DoubleListNode(0);
        DoubleListNode tmp = new DoubleListNode(0);
        //若头结点有next节点，先获得头结点的next，再修改头结点的next和last指向
        if (head.next != null) {
            cur.next = head.next;
            head.next = null;
            head.last = cur.next;
        }
        //若当前节点(cur.next)的next不为空，则继续遍历
        while (cur.next.next != null) {
            //获得当前节点的下一节点
            tmp.next = cur.next.next;
            //将当前节点的last指向下一节点
            cur.next.last = tmp.next;
            //将当前节点的next指向前一节点
            cur.next.next = head;
            //当前节点已完成指向修改，将当前节点保存为head，作为下次遍历当前节点的前一节点
            head = cur.next;
            //将当前节点的下一节点保存为当前节点
            cur.next = tmp.next;
        }
        //若当前节点(cur.next)的next为空，则将前一节点的last指向当前节点
        head.last = cur.next;
        //将当前节点的next指向前一节点
        cur.next.next = head;
        //因当前节点是链表尾节点，将当前节点的last指空
        cur.next.last = null;
        return cur.next;
    }
    
    public DoubleListNode reverseDoubleListNode2(DoubleListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        DoubleListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
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
        ListNode node = reverseNode2(p1_1);
        System.out.println("after reverse....");
        ListNode.printLinkedList(node);
    }
    
    @Test
    public void test2() {
        DoubleListNode p1_1 = new DoubleListNode(1);
        DoubleListNode p1_2 = new DoubleListNode(2);
        p1_1.next = p1_2;
        p1_2.last = p1_1;
        DoubleListNode p1_3 = new DoubleListNode(3);
        p1_2.next = p1_3;
        p1_3.last = p1_2;
        DoubleListNode p1_4 = new DoubleListNode(4);
        p1_3.next = p1_4;
        p1_4.last = p1_3;
        DoubleListNode p1_5 = new DoubleListNode(5);
        p1_4.next = p1_5;
        p1_5.last = p1_4;
        System.out.println("before reverse....");
        DoubleListNode.printDoubleLinkedList(p1_1);
        DoubleListNode node = reverseDoubleListNode2(p1_1);
        System.out.println("after reverse....");
        DoubleListNode.printDoubleLinkedList(node);
    }
}
