package problems.dataStructure.linkedlist;

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
        System.out.println("positive order : ");
        while (pHead != null) {
            System.out.print(pHead.value);
            if (pHead.next != null)
                System.out.print(" -> ");
            else
                break;
            pHead = pHead.next;
        }
        System.out.println("\nnegative order : ");
        while (pHead != null) {
            System.out.print(pHead.value);
            if (pHead.last != null)
                System.out.print(" -> ");
            else
                break;
            pHead = pHead.last;
        }
    }
}
