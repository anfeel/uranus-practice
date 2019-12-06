package dataStructure.tree;

import java.util.Stack;

import org.junit.Test;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
    
    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    
            1
           / \
          2   2
         / \ / \
        3  4 4  3
    但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    
            1
           / \
          2   2
           \   \
           3    3
    说明:
    
    如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/symmetric-tree
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: IsSymmetric.java, v 0.1 2019年12月5日 下午4:48:46 anfeel Exp $
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        if (root == null)
            return true;
        leftStack.add(root.left);
        rightStack.add(root.right);
        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            TreeNode left = leftStack.pop();
            TreeNode right = rightStack.pop();
            if (left != null && right != null && left.val == right.val) {
                if ((left.left != null && right.right != null) || (left.right != null && right.left != null)) {
                    leftStack.add(left.left);
                    leftStack.add(left.right);
                    rightStack.add(right.right);
                    rightStack.add(right.left);
                } else if (left.left == null && right.right == null && left.right == null && right.left == null)
                    continue;
                else
                    return false;
            } else if (left == null && right == null) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        System.out.println(isSymmetric(t1));
    }

    @Test
    public void test2() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(isSymmetric(t1));
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
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t5.right = t9;
        System.out.println(isSymmetric(t1));
    }

    @Test
    public void test4() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;

        System.out.println(isSymmetric(t1));
    }

    @Test
    public void test5() {
        TreeNode t1 = new TreeNode(1);
        System.out.println(isSymmetric(t1));
    }

    @Test
    public void test6() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.right = t5;
        t3.left = t6;
        System.out.println(isSymmetric(t1));
    }

    @Test
    public void test7() {
        TreeNode t1 = null;
        System.out.println(isSymmetric(t1));
    }
}
