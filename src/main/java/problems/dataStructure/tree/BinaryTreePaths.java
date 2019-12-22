package problems.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。

    说明: 叶子节点是指没有子节点的节点。
    
    示例:
    
    输入:
    
       1
     /   \
    2     3
     \
      5
    
    输出: ["1->2->5", "1->3"]
    
    解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/binary-tree-paths
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: BinaryTreePaths.java, v 0.1 2019年11月5日 下午2:17:05 prd-fuy Exp $
 */
public class BinaryTreePaths {
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root != null) {
            if (root.left != null)
                list.addAll(getPath(root.left, root.val + "->"));
            if (root.right != null)
                list.addAll(getPath(root.right, root.val + "->"));
            if (root.left == null && root.right == null)
                list.add(String.valueOf(root.val));
        }
        return list;
    }
    
    public List<String> getPath(TreeNode root, String path) {
        List<String> list = new ArrayList<String>();
        if (root.left != null)
            list.addAll(getPath(root.left, path + root.val + "->"));
        if (root.right != null)
            list.addAll(getPath(root.right, path + root.val + "->"));
        if (root.left == null && root.right == null)
            list.add(path + root.val);
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
        List<String> list = binaryTreePaths(t1);
        for (String string : list) {
            System.out.println(string);
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
        t3.left = t4;
        t3.right = t5;
        t5.left = t6;
        t5.right = t7;
        t7.left = t8;
        t7.right = t9;
        List<String> list = binaryTreePaths(t1);
        for (String string : list) {
            System.out.println(string);
        }
    }
    
    @Test
    public void test3() {
        List<String> list = binaryTreePaths(null);
        for (String string : list) {
            System.out.println(string);
        }
    }
    
    @Test
    public void test4() {
        TreeNode t1 = new TreeNode(1);
        List<String> list = binaryTreePaths(t1);
        for (String string : list) {
            System.out.println(string);
        }
    }
}
