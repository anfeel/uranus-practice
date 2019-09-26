package org.szfs.basic.web.demo.test.tree;

import org.junit.Test;

/**
 * 通过有序数组生成平衡搜索二叉树
 * @author prd-fuy
 * @version $Id: BuildBST.java, v 0.1 2019年9月26日 下午5:35:42 prd-fuy Exp $
 */
public class BuildBST {
    
    public TreeNode buildBST(int[] arr, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(arr[start]);
        TreeNode node = new TreeNode(arr[(start + end) / 2]);
        node.left = buildBST(arr, start, ((start + end) / 2) - 1);
        node.right = buildBST(arr, ((start + end) / 2) + 1, end);
        return node;
    }
    
    public TreeNode build(int[] arr) {
        if (arr == null)
            return null;
        else
            return buildBST(arr, 0, arr.length - 1);
    }
    
    @Test
    public void test1() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        TreeNode node = build(arr);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(node);
    }
    
    @Test
    public void test2() {
        System.out.println();
        int[] arr = { 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 15 };
        TreeNode node = buildBST(arr, 0, arr.length - 1);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(node);
    }
}
