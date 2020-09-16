package problems.dataStructure.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $ Id:Codec, v 0.1 2020年09月16日 11:33 anfeel Exp $
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuffer sb = new StringBuffer();
        getStr(queue, sb, 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] arr = data.split(",");
        return getTree(arr, 0);
    }

    private TreeNode getTree(String[] arr, int pos) {
        TreeNode cur = null;
        if (pos >= arr.length)
            return cur;
        String s = arr[pos];
        if (!"X".equals(s)) {
            cur = new TreeNode(Integer.parseInt(arr[pos]));
            cur.left = getTree(arr, 2 * pos + 1);
            cur.right = getTree(arr, 2 * pos + 2);
        }
        return cur;
    }

    private void getStr(Queue<TreeNode> queue, StringBuffer res, int level) {
        if (queue.isEmpty())
            return;
        Queue<TreeNode> next = new LinkedList<>();
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                res.append(cur.val + ",");
                next.add(cur.left);
                next.add(cur.right);
            } else {
                res.append("X,");
                next.add(null);
                next.add(null);
                count++;
            }
        }
        if (count == level) {
            res.delete(res.length() - 2 * count - 1, res.length());
            return;
        }
        getStr(next, res, 2 * level);
    }

    /**
     *  1,2,3,4,X,6,7,5,X,X,X,X,X,8,X
     */
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
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(t1);
        System.out.println();
        String res = serialize(t1);
        System.out.println(res);
    }

    @Test
    public void test2() {
        String string = "1,2,3,4,X,6,7,5,X,X,X,X,X,8,X";
        TreeNode root = deserialize(string);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(root);
    }


    @Test
    public void test3() {
        TreeNode t1 = null;
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(t1);
        System.out.println();
        String res = serialize(t1);
        System.out.println(res);
    }

    @Test
    public void test4() {
        TreeNode t1 = new TreeNode(1);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(t1);
        System.out.println();
        String res = serialize(t1);
        System.out.println(res);
    }


    @Test
    public void test5() {
        String string = "";
        TreeNode root = deserialize(string);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(root);
    }

    @Test
    public void test6() {
        String string = "1";
        TreeNode root = deserialize(string);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.inOrderRecur(root);
    }
}
