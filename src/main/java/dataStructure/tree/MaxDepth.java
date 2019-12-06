package dataStructure.tree;

import org.junit.Test;

/**
 * 给定一个二叉树，找出其最大深度。
    
    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    
    说明: 叶子节点是指没有子节点的节点。
    
    示例：
    给定二叉树 [3,9,20,null,null,15,7]，
    
        3
       / \
      9  20
        /  \
       15   7
    返回它的最大深度 3 。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: MaxDepth.java, v 0.1 2019年12月6日 下午3:54:45 anfeel Exp $
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return getDepth(root, 1);
    }

    public int getDepth(TreeNode root, int depth) {
        int leftDepth = 0, rightDepth = 0;
        if (root == null)
            return depth;
        if (root.left != null)
            leftDepth = getDepth(root.left, depth + 1);
        else
            leftDepth = depth;
        if (root.right != null)
            rightDepth = getDepth(root.right, depth + 1);
        else
            rightDepth = depth;
        if (leftDepth > rightDepth)
            return leftDepth;
        else
            return rightDepth;
    }

    @Test
    public void test1() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t1.left = t2;
        t2.right = t3;
        System.out.println(maxDepth(t1));
    }

    @Test
    public void test2() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        System.out.println(maxDepth(t1));
    }

    @Test
    public void test3() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(2);
        t1.left = t2;
        t2.right = t3;
        t3.left = t4;
        t4.right = t5;
        t5.left = t6;
        System.out.println(maxDepth(t1));
    }

    @Test
    public void test4() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(2);
        t1.left = t2;
        t2.right = t3;
        t3.left = t4;
        t1.right = t5;
        t5.left = t6;
        System.out.println(maxDepth(t1));
    }

    @Test
    public void test5() {
        TreeNode t1 = null;
        System.out.println(maxDepth(t1));
    }

}
