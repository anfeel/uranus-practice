package problems.dataStructure.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 例如：
 * 输入: 原始二叉搜索树:
 *
 *               5
 *             /  \
 *            3    8
 *           / \  / \
 *         2   4 7   13
 *
 * 输出: 转换为累加树:
 *               33
 *             /   \
 *           37     21
 *          / \    / \
 *        42  40  28  13
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $ Id:ConvertBST, v 0.1 2020年01月17日 13:49 anfeel Exp $
 */
public class ConvertBST {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        getValue(root);
        return root;
    }

    public void getValue(TreeNode root) {
        if (root == null)
            return;
        if (root.right != null)
            getValue(root.right);
        sum += root.val;
        root.val = sum;
        if (root.left != null)
            getValue(root.left);
    }


    public TreeNode convertBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.right != null)
                stack.push(cur.right);
            else {
                sum += cur.val;
                cur.val = sum;
                if (cur.left != null)
                    stack.push(cur.left);
                else
                    stack.pop();
            }
        }
        return root;
    }

    @Test
    public void test1() {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(13);
        t1.left = t2;
        t1.right = t3;
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(t1);
        TreeNode cur = convertBST(t1);
        tree.inOrderRecur(t1);
    }

    @Test
    public void test2() {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(13);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(t1);
        TreeNode cur = convertBST(t1);
        tree.inOrderRecur(t1);
    }

    @Test
    public void test3() {
        TreeNode t1 = null;
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(t1);
        TreeNode cur = convertBST(t1);
        tree.inOrderRecur(t1);
    }


}
