package problems.dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

  

 示例 :
 给定二叉树

 1
 / \
 2   3
 / \
 4   5
 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $ Id:DiameterOfBinaryTree, v 0.1 2020年01月18日 14:35 anfeel Exp $
 */
public class DiameterOfBinaryTree {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;
        int depth = getDepth(root);
        return diameter;
    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        //左子树的高度
        int left = root.left != null ? getDepth(root.left) + 1 : 0;
        //右子树的高度
        int right = root.right != null ? getDepth(root.right) + 1 : 0;
        int depth = Math.max(left, right);
        diameter = Math.max(diameter, left + right);
        return depth;
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

    @Test
    public void test6() {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(-7);
        TreeNode t3 = new TreeNode(-3);
        TreeNode t4 = new TreeNode(-9);
        TreeNode t5 = new TreeNode(-3);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(-7);
        TreeNode t8 = new TreeNode(-4);
        TreeNode t9 = new TreeNode(6);
        TreeNode t10 = new TreeNode(-6);
        TreeNode t11 = new TreeNode(-6);
        TreeNode t12 = new TreeNode(0);
        TreeNode t13 = new TreeNode(6);
        TreeNode t14 = new TreeNode(5);
        TreeNode t15 = new TreeNode(9);
        TreeNode t16 = new TreeNode(-1);
        TreeNode t17 = new TreeNode(-4);
        TreeNode t18 = new TreeNode(-2);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        t4.left = t6;
        t4.right = t7;
        t5.left = t8;
        t6.left = t9;
        t6.right = t10;
        t7.right = t11;
        t9.left = t12;
        t9.right = t13;
        t10.left = t14;
        t11.left = t15;
        t12.right = t16;
        t13.right = t17;
        t15.left = t18;
        Assert.assertEquals(8, diameterOfBinaryTree(t1));
    }

    @Test
    public void test7() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        Assert.assertEquals(1, diameterOfBinaryTree(t1));
    }
}
