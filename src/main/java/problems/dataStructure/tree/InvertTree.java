package problems.dataStructure.tree;

import org.junit.Test;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:InvertTree, v 0.1 2020年09月16日 9:40 anfeel Exp $
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if (root == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);
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
        t7.left = t8;
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(t1);
        System.out.println();
        TreeNode cur = invertTree(t1);
        tree.inOrderRecur(cur);
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
        t2.right = t3;
        t3.left = t4;
        t4.left = t5;
        t5.left = t6;
        t6.right = t7;
        t7.left = t8;
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(t1);
        System.out.println();
        TreeNode cur = invertTree(t1);
        tree.inOrderRecur(cur);
    }

    @Test
    public void test3() {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(t1);
        System.out.println();
        TreeNode cur = invertTree(t1);
        tree.inOrderRecur(cur);
    }

    @Test
    public void test4() {
        TreeNode t1 = null;
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(t1);
        System.out.println();
        TreeNode cur = invertTree(t1);
        tree.inOrderRecur(cur);
    }

    @Test
    public void test5() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t2.left = t3;
        t3.left = t4;
        t4.left = t5;
        t5.left = t6;
        t6.left = t7;
        t7.left = t8;
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(t1);
        System.out.println();
        TreeNode cur = invertTree(t1);
        tree.inOrderRecur(cur);
    }
}
