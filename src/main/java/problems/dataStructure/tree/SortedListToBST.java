package problems.dataStructure.tree;

import org.junit.Test;
import problems.dataStructure.linkedlist.ListNode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $ Id:SortedListToBST, v 0.1 2020年08月18日 10:31 anfeel Exp $
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        int[] arr = new int[len];
        cur = head;
        for (int i = 0; i < len; i++) {
            arr[i] = cur.val;
            cur = cur.next;
        }
        TreeNode root = getRoot(arr, 0, len - 1);
        return root;
    }

    public TreeNode getRoot(int[] arr, int begin, int end) {
        if (begin > end)
            return null;
        if (begin == end)
            return new TreeNode(arr[begin]);
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = getRoot(arr, begin, mid - 1);
        root.right = getRoot(arr, mid + 1, end);
        return root;
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
        ListNode p1_6 = new ListNode(6);
        p1_5.next = p1_6;
        ListNode.printLinkedList(p1_1);
        TreeNode root = sortedListToBST(p1_1);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(root);
    }

    @Test
    public void test2() {
        ListNode p1_1 = new ListNode(-10);
        ListNode p1_2 = new ListNode(-3);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(0);
        p1_2.next = p1_3;
        ListNode p1_4 = new ListNode(5);
        p1_3.next = p1_4;
        ListNode p1_5 = new ListNode(9);
        p1_4.next = p1_5;
        ListNode.printLinkedList(p1_1);
        TreeNode root = sortedListToBST(p1_1);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(root);
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
        ListNode p1_5 = new ListNode(5);
        p1_4.next = p1_5;
        ListNode p1_6 = new ListNode(6);
        p1_5.next = p1_6;
        ListNode p1_7 = new ListNode(7);
        p1_6.next = p1_7;
        ListNode.printLinkedList(p1_1);
        TreeNode root = sortedListToBST(p1_1);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(root);
    }

    @Test
    public void test4() {
        ListNode p1_1 = new ListNode(-10);
        ListNode.printLinkedList(p1_1);
        TreeNode root = sortedListToBST(p1_1);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(root);
    }

    @Test
    public void test5() {
        ListNode p1_1 = new ListNode(0);
        ListNode.printLinkedList(p1_1);
        TreeNode root = sortedListToBST(p1_1);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(root);
    }

    @Test
    public void test6() {
        TreeNode root = sortedListToBST(null);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(root);
    }

}
