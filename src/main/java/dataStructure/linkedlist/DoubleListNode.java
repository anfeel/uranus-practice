package dataStructure.linkedlist;

/**
 * 双链表节点结构
 * @author prd-fuy
 * @version $Id: DoubleListNode.java, v 0.1 2019年9月27日 上午11:17:10 prd-fuy Exp $
 */
public class DoubleListNode {
    
    public int            value;
    public DoubleListNode last;
    public DoubleListNode next;
    
    public DoubleListNode(int data) {
        this.value = data;
    }
    
    public static void printDoubleLinkedList(DoubleListNode pHead) {
        while (pHead != null) {
            System.out.println("positive order : node -> " + pHead.value);
            if (pHead.next == null)
                break;
            pHead = pHead.next;
        }
        System.out.println("begin from the end of list.....");
        while (pHead != null) {
            System.out.println("negative order :node -> " + pHead.value);
            if (pHead.last == null)
                break;
            pHead = pHead.last;
        }
    }
}
