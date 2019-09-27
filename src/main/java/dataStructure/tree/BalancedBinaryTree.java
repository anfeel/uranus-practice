package dataStructure.tree;

import org.junit.Test;

/**
 * 平衡二叉树的性质：要么是一颗空树，要么任何一个节点的左右子树高度差的绝对值不超过1.
 * 给定一棵二叉树的头结点head，判断这棵二叉树是否为平衡二叉树
 * @author prd-fuy
 * @version $Id: BalancedBinaryTree.java, v 0.1 2019年9月11日 上午11:08:12 prd-fuy Exp $
 */
public class BalancedBinaryTree {
    
    public boolean isBalancedTree(TreeNode head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getDepth(head, 1, res);
        return res[0];
    }
    
    public int getDepth(TreeNode head, int level, boolean[] res) {
        if (head == null)
            return level;
        int leftDepth = getDepth(head.left, level + 1, res);
        if (!res[0])
            return level;
        int rightDepth = getDepth(head.right, level + 1, res);
        if (!res[0])
            return level;
        if (Math.abs(leftDepth - rightDepth) > 1)
            res[0] = false;
        return Math.max(leftDepth, rightDepth);
    }
    
    @Test
    public void test1() {
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
        System.out.println("This TreeNode is balancedTree? " + isBalancedTree(t1));
    }
    
}
