package problems.dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:MinDepth, v 0.1 2020年08月21日 10:09 anfeel Exp $
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int[] min = new int[1];
        getDepth(root, 1, min);
        return min[0];
    }

    public void getDepth(TreeNode root, int depth, int[] min) {
        if (root.left == null && root.right == null) {
            min[0] = min[0] == 0 ? depth : Math.min(min[0], depth);
            return;
        }
        if (root.left != null)
            getDepth(root.left, depth + 1, min);
        if (root.right != null)
            getDepth(root.right, depth + 1, min);
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
        Assert.assertEquals(3, minDepth(t1));
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
        t3.left = t4;
        t4.left = t5;
        t5.left = t6;
        t6.left = t7;
        Assert.assertEquals(2, minDepth(t1));
    }


    @Test
    public void test3() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t3.right = t4;
        t4.right = t5;
        t5.right = t6;
        t6.right = t7;
        t7.right = t10;
        t2.left = t8;
        t8.left = t9;
        Assert.assertEquals(4, minDepth(t1));
    }

    @Test
    public void test4() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t3.right = t4;
        t4.right = t5;
        t5.right = t6;
        t6.right = t7;
        t7.right = t10;
        t2.left = t8;
        Assert.assertEquals(3, minDepth(t1));
    }

    @Test
    public void test5() {
        Assert.assertEquals(0, minDepth(null));
    }

    @Test
    public void test6() {
        TreeNode t1 = new TreeNode(1);
        Assert.assertEquals(1, minDepth(t1));
    }

    @Test
    public void test7() {
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
        t2.right = t5;
        t3.left = t6;
        Assert.assertEquals(3, minDepth(t1));
    }

    @Test
    public void test8() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t2.right = t3;
        t3.left = t4;
        t4.right = t5;
        t5.left = t6;
        t6.right = t7;
        t7.left = t8;
        Assert.assertEquals(8, minDepth(t1));
    }
}
