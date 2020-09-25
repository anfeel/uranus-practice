package problems.dataStructure.tree;

import org.junit.Test;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:BuildTree, v 0.1 2020年09月25日 9:32 anfeel Exp $
 */
public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = getNode(inorder, postorder, 0, postorder.length - 1);
        return root;
    }

    public TreeNode getNode(int[] inorder, int[] postorder, int begin, int end) {
        if (begin > end || end < 0)
            return null;
        int inRootPos = 0;
        int rootVal = postorder[end];
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal)
                inRootPos = i;
        }
        int left = inRootPos - begin;
        TreeNode root = new TreeNode(rootVal);
        int leftEnd = begin + left - 1;
        root.left = getNode(inorder, postorder, begin, leftEnd);
        int rightBeg = begin + left;
        root.right = getNode(inorder, postorder, rightBeg, end - 1);
        return root;
    }

    @Test
    public void test1() {
        TreeNode root = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(root);
        tree.postOrderRecur(root);
    }

    @Test
    public void test2() {

    }
}
