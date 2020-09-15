package problems.dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:Trie, v 0.1 2020年09月15日 10:52 anfeel Exp $
 */
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            Map<Character, TrieNode> curMap = cur.map;
            TrieNode node = null;
            if (!curMap.containsKey(c)) {
                node = new TrieNode(c);
                if (i == arr.length - 1)
                    node.end = true;
                curMap.put(c, node);
            } else {
                node = curMap.get(c);
                if (i == arr.length - 1)
                    node.end = true;
            }
            cur = node;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            TrieNode node = null;
            Map<Character, TrieNode> curMap = cur.map;
            if (curMap.containsKey(c)) {
                node = curMap.get(c);
                if (i == arr.length - 1 && !node.end)
                    return false;
                cur = node;
            } else
                return false;
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0)
            return false;
        char[] arr = prefix.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            TrieNode node = null;
            Map<Character, TrieNode> curMap = cur.map;
            if (curMap.containsKey(c)) {
                node = curMap.get(c);
                cur = node;
            } else
                return false;
        }
        return true;
    }

    @Test
    public void test1() {
        Trie trie = new Trie();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));   // 返回 true
        Assert.assertFalse(trie.search("app"));     // 返回 false
        Assert.assertTrue(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        Assert.assertTrue(trie.search("app"));     // 返回 true
    }

    @Test
    public void test2() {
        Trie trie = new Trie();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));   // 返回 true
        Assert.assertFalse(trie.search("app"));     // 返回 false
        Assert.assertTrue(trie.startsWith("app")); // 返回 true
        trie.insert("");
        Assert.assertTrue(trie.search("app"));     // 返回 true
    }
}
