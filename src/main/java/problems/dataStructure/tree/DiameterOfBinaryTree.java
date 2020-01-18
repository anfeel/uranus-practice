package problems.dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $ Id:DiameterOfBinaryTree, v 0.1 2020年01月18日 14:35 anfeel Exp $
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        return getDepth(1, root.left) + getDepth(1, root.right);
    }

    public int getDepth(int curDepth, TreeNode root) {
        if (root == null)
            return curDepth - 1;
        int ld = getDepth(curDepth + 1, root.left);
        int rd = getDepth(curDepth + 1, root.right);
        return ld > rd ? ld : rd;
    }

    @Test
    public void test1() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.left = t5;
        Assert.assertEquals(3, diameterOfBinaryTree(t1));
    }

    @Test
    public void test2() {
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
        t7.left = t8;
        Assert.assertEquals(6, diameterOfBinaryTree(t1));
    }

    @Test
    public void test3() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        Assert.assertEquals(2, diameterOfBinaryTree(t1));
    }

    @Test
    public void test4() {
        TreeNode t1 = new TreeNode(1);
        Assert.assertEquals(0, diameterOfBinaryTree(t1));
    }

    @Test
    public void test5() {
        Assert.assertEquals(0, diameterOfBinaryTree(null));
    }
}
