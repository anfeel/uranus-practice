package problems.design;

import java.util.HashMap;
import java.util.Random;

import org.junit.Test;

/**
 * 实现一个数据结构支持以下操作：

    Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
    Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
    GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
    GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
    挑战：以 O(1) 的时间复杂度实现所有操作。
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/all-oone-data-structure
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: AllOne.java, v 0.1 2019年11月4日 上午10:55:41 prd-fuy Exp $
 */
public class AllOne {
    
    HashMap<String, Integer> mapK2V;
    HashMap<String, Node>    mapK2N;
    
    DoubleLinkedList         doubleLinkedList;
    
    class Node {
        public int                      value;
        public HashMap<String, Integer> map;
        public Node                     next;
        public Node                     last;
        
        public Node(int value, HashMap<String, Integer> map) {
            this.value = value;
            this.map = map;
        }
    }
    
    class DoubleLinkedList {
        public Node head;
        public Node tail;
        
        public Node addNodeAfter(Node cur, String key, int value) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put(key, value);
            Node node = new Node(value, map);
            mapK2N.put(key, node);
            if (cur == null) {
                this.head = node;
                this.tail = node;
            } else if (cur.next == null) {
                cur.next = node;
                node.last = cur;
                this.tail = node;
            } else {
                node.next = cur.next;
                node.last = cur;
                cur.next.last = node;
                cur.next = node;
            }
            return node;
        }
        
        public void addNodeBefore(Node cur, String key, int value) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put(key, value);
            Node node = new Node(value, map);
            mapK2N.put(key, node);
            if (cur.last == null) {
                node.next = cur;
                cur.last = node;
                this.head = node;
            } else {
                node.last = cur.last;
                cur.last.next = node;
                node.next = cur;
                cur.last = node;
            }
        }
        
        public void delNode(Node node) {
            if (node != this.head && node != this.tail) {
                node.last.next = node.next;
                node.next.last = node.last;
            }
            if (node == this.head) {
                this.head = node.next;
                if (this.head != null)
                    this.head.last = null;
            }
            if (node == this.tail) {
                this.tail = node.last;
                if (this.tail != null)
                    this.tail.next = null;
            }
            
        }
        
    }
    
    /** Initialize your data structure here. */
    public AllOne() {
        this.mapK2V = new HashMap<>();
        this.mapK2N = new HashMap<>();
        this.doubleLinkedList = new DoubleLinkedList();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        //若map中没有key
        if (!mapK2V.containsKey(key)) {
            mapK2V.put(key, 1);
            //若head不为空
            if (doubleLinkedList.head != null) {
                //在head节点中操作
                if (doubleLinkedList.head.value == 1) {
                    doubleLinkedList.head.map.put(key, 1);
                    mapK2N.put(key, doubleLinkedList.head);
                } else {
                    //在head节点后新增节点
                    this.doubleLinkedList.addNodeBefore(this.doubleLinkedList.head, key, 1);
                }
            } else {
                //若head为空，则新增节点插入
                this.doubleLinkedList.addNodeAfter(null, key, 1);
            }
        }
        //若map中已有key
        else {
            int value = mapK2V.get(key);
            Node n = mapK2N.get(key);
            value++;
            mapK2V.put(key, value);
            //若key对应的node后有节点，并且该节点的值等于value++后的值，则直接插入节点map
            if (n.next != null && n.next.value == value) {
                n.next.map.put(key, value);
                mapK2N.put(key, n.next);
            }
            //若key对应的node后没有节点，或者若该节点的值不等于value++后的值，则新增节点
            else {
                Node node = this.doubleLinkedList.addNodeAfter(n, key, value);
                mapK2N.put(key, node);
            }
            //原node需删除key，若删除之后map为空，则删除node
            n.map.remove(key);
            if (n.map.size() == 0)
                this.doubleLinkedList.delNode(n);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (mapK2V.containsKey(key)) {
            int value = mapK2V.get(key);
            Node node = mapK2N.get(key);
            if (value == 1) {
                mapK2V.remove(key);
                node.map.remove(key);
                if (node.map.size() == 0) {
                    this.doubleLinkedList.delNode(node);
                    mapK2N.remove(key);
                }
            } else {
                --value;
                mapK2V.put(key, value);
                node.map.remove(key);
                if (node.last != null && node.last.value == value) {
                    node.last.map.put(key, value);
                    mapK2N.put(key, node.last);
                    if (node.map.size() == 0)
                        this.doubleLinkedList.delNode(node);
                } else {
                    this.doubleLinkedList.addNodeBefore(node, key, value);
                    this.doubleLinkedList.delNode(node);
                }
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (this.doubleLinkedList.tail != null) {
            Node node = this.doubleLinkedList.tail;
            HashMap<String, Integer> map = node.map;
            String[] s = (String[]) map.keySet().toArray(new String[0]);
            return s[new Random().nextInt(s.length)];
        }
        return "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (this.doubleLinkedList.head != null) {
            Node node = this.doubleLinkedList.head;
            HashMap<String, Integer> map = node.map;
            String[] s = (String[]) map.keySet().toArray(new String[0]);
            return s[new Random().nextInt(s.length)];
        }
        return "";
    }
    
    @Test
    public void test1() {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("a");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.print(" MinKey = " + allOne.getMinKey());
        allOne.inc("b");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.print(" MinKey = " + allOne.getMinKey());
        System.out.println();
    }
    
    @Test
    public void test2() {
        AllOne allOne = new AllOne();
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.print(" MinKey = " + allOne.getMinKey());
        allOne.inc("b");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.print(" MinKey = " + allOne.getMinKey());
        System.out.println();
    }
    
    @Test
    public void test3() {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("a");
        allOne.dec("a");
        allOne.dec("a");
        allOne.dec("a");
        allOne.dec("a");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.print(" MinKey = " + allOne.getMinKey());
        allOne.inc("b");
        allOne.inc("b");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.print(" MinKey = " + allOne.getMinKey());
        allOne.inc("c");
        allOne.inc("a");
        allOne.inc("e");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.print(" MinKey = " + allOne.getMinKey());
        System.out.println();
    }
    
    @Test
    public void test4() {
        AllOne allOne = new AllOne();
        allOne.dec("a");
        allOne.dec("a");
        allOne.dec("a");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.print(" MinKey = " + allOne.getMinKey());
        allOne.inc("b");
        allOne.inc("b");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.print(" MinKey = " + allOne.getMinKey());
        allOne.inc("c");
        allOne.inc("a");
        allOne.inc("e");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.print(" MinKey = " + allOne.getMinKey());
        System.out.println();
    }
    
    @Test
    public void test5() {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.dec("b");
        allOne.dec("b");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.print(" MinKey = " + allOne.getMinKey());
        System.out.println();
    }
    
    @Test
    public void test6() {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("goodbye");
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("leet");
        allOne.dec("hello");
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("code");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.println();
    }
    
    @Test
    public void test7() {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        System.out.print(" MinKey = " + allOne.getMinKey());
        allOne.dec("a");
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.print(" MinKey = " + allOne.getMinKey());
        System.out.println();
    }
    
    @Test
    public void test8() {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("d");
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("d");
        allOne.inc("c");
        allOne.inc("d");
        allOne.inc("d");
        allOne.inc("a");
        System.out.print(" MinKey = " + allOne.getMinKey());
        System.out.print(" MaxKey = " + allOne.getMaxKey());
        System.out.println();
    }
}
