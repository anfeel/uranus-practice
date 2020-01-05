package problems.dataStructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

begin to intersect at node c1.

Example 1:

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). 
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. 
There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

Example 2:

Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). 
From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. 
There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 
Example 3:

Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. 
Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
 
Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。q
 * @author anfeel
 * @version $Id: GetIntersectionNode.java, v 0.1 2019年12月30日 下午4:01:52 anfeel Exp $
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (set.contains(headA))
                    return headA;
                else {
                    set.add(headA);
                    headA = headA.next;
                }
            }
            if (headB != null) {
                if (set.contains(headB))
                    return headB;
                else {
                    set.add(headB);
                    headB = headB.next;
                }
            }
        }
        return null;
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

        ListNode p2_1 = new ListNode(9);
        ListNode p2_2 = new ListNode(8);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(8);
        p2_2.next = p2_3;
        p2_3.next = p1_4;

        System.out.println("first linkedlist:");
        ListNode.printLinkedList(p1_1);
        System.out.println("second linkedlist:");
        ListNode.printLinkedList(p2_1);

        ListNode result = getIntersectionNode(p1_1, p2_1);
        System.out.println("result:" + (result == null ? null : result.val));

    }

    @Test
    public void test2() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;

        ListNode p2_1 = new ListNode(9);
        ListNode p2_2 = new ListNode(8);
        p2_1.next = p2_2;
        ListNode p2_3 = new ListNode(8);
        p2_2.next = p2_3;

        System.out.println("first linkedlist:");
        ListNode.printLinkedList(p1_1);
        System.out.println("second linkedlist:");
        ListNode.printLinkedList(p2_1);

        ListNode result = getIntersectionNode(p1_1, p2_1);
        System.out.println("result:" + (result == null ? null : result.val));

    }

    @Test
    public void test3() {

        ListNode result = getIntersectionNode(null, null);
        System.out.println("result:" + (result == null ? null : result.val));
    }
}
