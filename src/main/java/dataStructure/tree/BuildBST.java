package dataStructure.tree;

import org.junit.Test;

/**
 * 通过有序数组生成平衡搜索二叉树
 * @author prd-fuy
 * @version $Id: BuildBST.java, v 0.1 2019年9月26日 下午5:35:42 prd-fuy Exp $
 */
public class BuildBST {

    public TreeNode build(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[] nums, int begin, int end) {
        if (begin == end)
            return new TreeNode(nums[begin]);
        int i = (begin + end) / 2;
        TreeNode node = new TreeNode(nums[i]);
        if (begin <= i - 1)
            node.left = buildBST(nums, begin, i - 1);
        if (end >= i + 1)
            node.right = buildBST(nums, i + 1, end);
        return node;
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
