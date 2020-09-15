package problems.dataStructure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树节点
 * @author anfeel
 * @version $ Id:TrieNode, v 0.1 2020年09月15日 11:42 anfeel Exp $
 */
public class TrieNode {
    public char val;
    public boolean end;
    public Map<Character, TrieNode> map;

    public TrieNode(char val) {
        this.val = val;
        this.end = false;
        this.map = new HashMap<>();
    }
}
