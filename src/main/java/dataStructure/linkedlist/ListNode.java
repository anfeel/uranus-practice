package dataStructure.linkedlist;

/**
 * 单链表数据结构
 * @author prd-fuy
 * @version $Id: ListNode.java, v 0.1 2019年9月27日 上午11:13:32 prd-fuy Exp $
 */
public class ListNode {
    public int      value;
    public ListNode next;
    
    public ListNode(int data) {
        this.value = data;
    }
    
    public static void printLinkedList(ListNode pHead) {
        while (pHead != null) {
            System.out.print(pHead.value);
            if (pHead.next != null)
                System.out.print(" -> ");
            pHead = pHead.next;
        }
        System.out.println();
    }
}
