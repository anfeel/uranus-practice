package problems.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.

    示例 1:
    
    输入:
        3
       / \
      9  20
        /  \
       15   7
    输出: [3, 14.5, 11]
    解释:
    第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
    注意：
    
    节点值的范围在32位有符号整数范围内。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: AverageOfLevels.java, v 0.1 2019年11月3日 上午10:23:36 anfeel Exp $
 */
public class AverageOfLevels {

    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<Double>();
        if (root != null)
            s1.add(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                double average = 0;
                int count = 0;
                while (!s1.isEmpty()) {
                    TreeNode n = s1.pop();
                    if (n.left != null)
                        s2.add(n.left);
                    if (n.right != null)
                        s2.add(n.right);
                    average += n.val;
                    count++;
                }
                list.add(average / count);
            }
            if (!s2.isEmpty()) {
                double average = 0;
                int count = 0;
                while (!s2.isEmpty()) {
                    TreeNode n = s2.pop();
                    if (n.left != null)
                        s1.add(n.left);
                    if (n.right != null)
                        s1.add(n.right);
                    average += n.val;
                    count++;
                }
                list.add(average / count);
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
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.left = t5;
        t3.left = t6;
        t3.right = t7;
        t7.left = t8;
        List<Double> list = averageOfLevels(t1);
        for (Double double1 : list) {
            System.out.print(" " + double1 + " ");
        }
        System.out.println();
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
        List<Double> list = averageOfLevels(t1);
        for (Double double1 : list) {
            System.out.print(" " + double1 + " ");
        }
        System.out.println();
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
        List<Double> list = averageOfLevels(t1);
        for (Double double1 : list) {
            System.out.print(" " + double1 + " ");
        }
        System.out.println();
    }
}
