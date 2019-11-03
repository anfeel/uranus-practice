package dataStructure.tree;

import org.junit.Test;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
    
    本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
    
    示例:
    
    给定有序数组: [-10,-3,0,5,9],
    
    一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
    
          0
         / \
       -3   9
       /   /
     -10  5
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
