package org.szfs.basic.web.demo.test.tree;

import java.util.Stack;

import org.junit.Test;

/**
 * 分别用递归和非递归方式实现二叉树先序、中序和后序遍历
 * 先序：根左右
 * 中序：左根右
 * 后序：左右根
 * @author prd-fuy
 * @version $Id: TraverseBinaryTree.java, v 0.1 2019年9月18日 下午12:31:04 prd-fuy Exp $
 */
public class TraverseBinaryTree {
    class TreeNode {
        int      val   = 0;
        TreeNode left  = null;
        TreeNode right = null;
        
        public TreeNode(int val) {
            this.val = val;
        }
    }
    
    /**
     * 先序递归遍历
     * @param root
     */
    public void preOrderRecur(TreeNode root) {
        if (root == null)
            return;
        System.out.printf(" %d ", root.val);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }
    
    /**
     * 先序非递归遍历
     * @param root
     */
    public void preOrderNonRecur(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.printf(" %d ", node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }
    
    /**
     * 中序递归遍历
     * @param root
     */
    public void inOrderRecur(TreeNode root) {
        if (root == null)
            return;
        inOrderRecur(root.left);
        System.out.printf(" %d ", root.val);
        inOrderRecur(root.right);
    }
    
    /**
     * 中序非递归遍历
     * @param root
     */
    public void inOrderNonRecur(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.printf(" %d ", root.val);
                root = root.right;
            }
        }
    }
    
    /**
     * 后序递归遍历
     * @param root
     */
    public void postOrderRecur(TreeNode root) {
        if (root == null)
            return;
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.printf(" %d ", root.val);
    }
    
    /**
     * 后序非递归遍历
     * @param root
     */
    public void postOrderNonRecur(TreeNode root) {
        
    }
    
    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.left = t5;
        t3.left = t6;
        t3.right = t7;
        t5.left = t8;
        System.out.println(" preOrder: ");
        preOrderRecur(t1);
        System.out.println("\n inOrder: ");
        inOrderRecur(t1);
        System.out.println("\n postOrder: ");
        postOrderRecur(t1);
        System.out.println("\n preOrderNonRecur: ");
        preOrderNonRecur(t1);
        System.out.println("\n inOrderNonRecur: ");
        inOrderNonRecur(t1);
    }
}
