package dataStructure.tree;

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
     * 使用两个栈
     * @param root
     */
    public void postOrderNonRecur(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.printf(" %d ", stack2.pop().val);
        }
    }
    
    /**
     * 后序非递归遍历
     * 使用一个栈
     * @param root
     */
    public void postOrderNonRecur2(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (cur.left != null && root != cur.left && root != cur.right) {
                stack.push(cur.left);
            } else if (cur.right != null && root != cur.right) {
                stack.push(cur.right);
            } else {
                System.out.printf(" %d ", stack.pop().val);
                root = cur;
            }
            
        }
    }
    
    /**
     * 中序！神级！遍历
     * morris遍历，利用叶子节点的空指针存储节点信息
     * 额外空间复杂度O(1)
     * @param root
     */
    public void inOrderBestRecur(TreeNode root) {
        if (root == null)
            return;
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            while (cur1.left != null) {
                cur2 = cur1.left;
                if (cur2.right != null) {
                    while (cur2 != null)
                        cur2 = cur2.right;
                } else
                    cur2.right = cur1;
                cur1 = cur2;
                
            }
        }
        
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
        TreeNode t9 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t5.right = t9;
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
        System.out.println("\n postOrderNonRecur , use two stack : ");
        postOrderNonRecur(t1);
        System.out.println("\n postOrderNonRecur , use one stack: ");
        postOrderNonRecur2(t1);
    }
}
