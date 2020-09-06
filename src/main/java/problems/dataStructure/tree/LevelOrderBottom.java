package problems.dataStructure.tree;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:LevelOrderBottom, v 0.1 2020年09月06日 9:40 anfeel Exp $
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<List<Integer>> stack = new Stack<>();
        levelTranverse(queue, stack);
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public void levelTranverse(Queue<TreeNode> queue, Stack<List<Integer>> stack) {
        if (queue.isEmpty())
            return;
        Queue<TreeNode> next = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null)
                next.add(cur.left);
            if (cur.right != null)
                next.add(cur.right);
            list.add(cur.val);
        }
        stack.add(list);
        levelTranverse(next, stack);
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
        List<List<Integer>> res = levelOrderBottom(t1);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.printf(" %d ", i);
            }
            System.out.println();
        }
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
        List<List<Integer>> res = levelOrderBottom(t1);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.printf(" %d ", i);
            }
            System.out.println();
        }
    }

    @Test
    public void test3() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        List<List<Integer>> res = levelOrderBottom(t1);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.printf(" %d ", i);
            }
            System.out.println();
        }
    }

    @Test
    public void test4() {
        TreeNode t1 = new TreeNode(1);
        List<List<Integer>> res = levelOrderBottom(t1);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.printf(" %d ", i);
            }
            System.out.println();
        }
    }

    @Test
    public void test5() {
        List<List<Integer>> res = levelOrderBottom(null);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.printf(" %d ", i);
            }
            System.out.println();
        }
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
        List<List<Integer>> res = levelOrderBottom(t1);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.printf(" %d ", i);
            }
            System.out.println();
        }
    }

    @Test
    public void test7() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        List<List<Integer>> res = levelOrderBottom(t1);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.printf(" %d ", i);
            }
            System.out.println();
        }
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
        t4.left = t5;
        t5.left = t6;
        t6.right = t7;
        t7.left = t8;
        List<List<Integer>> res = levelOrderBottom(t1);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.printf(" %d ", i);
            }
            System.out.println();
        }
    }
}
