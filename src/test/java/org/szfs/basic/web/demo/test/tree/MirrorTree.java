package org.szfs.basic.web.demo.test.tree;

import org.junit.Test;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
        输入描述:
        二叉树的镜像定义：源二叉树 
                    8
                   /  \
                  6   10
                 / \  / \
                5  7 9 11
                镜像二叉树
                    8
                   /  \
                  10   6
                 / \  / \
                11 9 7  5
 * @author prd-fuy
 * @version $Id: MirrorTree.java, v 0.1 2018年12月19日 上午9:20:18 prd-fuy Exp $
 */
public class MirrorTree {
    
    public void Mirror(TreeNode root) {
        TreeNode tmp;
        if (root != null && (root.left != null || root.right != null)) {
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            Mirror(root.left);
            Mirror(root.right);
        }
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
        TreeNode t8 = new TreeNode(8);
        TreeNode t6 = new TreeNode(6);
        TreeNode t10 = new TreeNode(10);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t11 = new TreeNode(11);
        t8.left = t6;
        t8.right = t10;
        t6.left = t5;
        t6.right = t7;
        t10.left = t9;
        t10.right = t11;
        print(t8);
        System.out.println();
        Mirror(t8);
        print(t8);
        System.out.println();
    }
    
    @Test
    public void test2() {
        TreeNode t8 = new TreeNode(8);
        print(t8);
        System.out.println();
        Mirror(t8);
        print(t8);
        System.out.println();
    }
    
    @Test
    public void test3() {
        print(null);
        System.out.println();
        Mirror(null);
        print(null);
        System.out.println();
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
        t1.left = t2;
        t2.left = t3;
        t3.left = t4;
        t4.left = t5;
        t5.left = t6;
        t6.left = t7;
        print(t1);
        System.out.println();
        Mirror(t1);
        print(t1);
        System.out.println();
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
        t1.right = t2;
        t2.right = t3;
        t3.right = t4;
        t4.right = t5;
        t5.right = t6;
        t6.right = t7;
        print(t1);
        System.out.println();
        Mirror(t1);
        print(t1);
        System.out.println();
    }
    
}
