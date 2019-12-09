package dataStructure.tree;

import org.junit.Test;

/**
 * 
 * @author anfeel
 * @version $Id: MergeTrees.java, v 0.1 2019年12月9日 下午3:38:32 anfeel Exp $
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        TreeNode r = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        r.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        r.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return r;
    }

    public void print(TreeNode root) {
        if (root != null) {
            if (root.left != null)
                print(root.left);

            System.out.print(root.val + " ");
            if (root.right != null)
                print(root.right);
        }
    }

    @Test
    public void test1() {
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(1);
        TreeNode t13 = new TreeNode(1);
        TreeNode t14 = new TreeNode(1);
        TreeNode t15 = new TreeNode(1);
        TreeNode t16 = new TreeNode(1);
        TreeNode t17 = new TreeNode(1);
        t11.left = t12;
        t11.right = t13;
        t12.left = t14;
        t14.left = t15;
        t13.left = t16;
        t13.right = t17;

        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(2);
        TreeNode t23 = new TreeNode(2);
        TreeNode t24 = new TreeNode(2);
        TreeNode t25 = new TreeNode(2);
        TreeNode t26 = new TreeNode(2);
        TreeNode t27 = new TreeNode(2);
        t21.left = t22;
        t21.right = t23;
        t22.left = t24;
        t24.left = t25;
        t23.left = t26;
        t23.right = t27;

        TreeNode t3 = mergeTrees(t11, t21);
        print(t3);
    }
}
