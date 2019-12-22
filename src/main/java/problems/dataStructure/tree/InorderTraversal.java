package problems.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * 给定一个二叉树，返回它的中序 遍历。

    示例:
    
    输入: [1,null,2,3]
       1
        \
         2
        /
       3
    
    输出: [1,3,2]
    进阶: 递归算法很简单，你可以通过迭代算法完成吗？
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: InorderTraversal.java, v 0.1 2019年12月16日 下午2:30:41 anfeel Exp $
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
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
        TreeNode t9 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t5.right = t9;
        System.out.println("\n inOrder: ");
        List<Integer> list = inorderTraversal(t1);
        for (int i : list) {
            System.out.printf(" %d ", i);
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
        TreeNode t9 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t5.right = t9;
        System.out.println("\n inOrder: ");
        List<Integer> list = inorderTraversal(null);
        for (int i : list) {
            System.out.printf(" %d ", i);
        }
    }

}
