package design;

import java.util.HashMap;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

    获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
    写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
    
    进阶:
    
    你是否可以在 O(1) 时间复杂度内完成这两种操作？
    
    示例:
    
    LRUCache cache = new LRUCache( 2 );//缓存容量 2
    
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // 返回  1
    cache.put(3, 3);    // 该操作会使得密钥 2 作废
    cache.get(2);       // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得密钥 1 作废
    cache.get(1);       // 返回 -1 (未找到)
    cache.get(3);       // 返回  3
    cache.get(4);       // 返回  4
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/lru-cache
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author prd-fuy
 * @version $Id: LRUCache.java, v 0.1 2019年11月1日 下午2:05:33 prd-fuy Exp $
 */
public class LRUCache {
    
    HashMap<Integer, Node> mapKeyToNode;
    HashMap<Node, Integer> mapNodeToKey;
    DoubleLinkedList       doubleLinkedList;
    int                    size;
    
    class Node {
        public int  value;
        public Node next;
        public Node last;
        
        public Node(int value) {
            this.value = value;
        }
    }
    
    class DoubleLinkedList {
        public Node head;
        public Node tail;
        
        public Node removeHead() {
            if (head == null)
                return null;
            else {
                Node node = this.head;
                this.head.next.last = null;
                this.head = this.head.next;
                return node;
            }
        }
        
        public void addTail(Node node) {
            if (tail != null) {
                this.tail.next = node;
                node.last = this.tail;
                this.tail = node;
            } else {
                this.head = node;
                this.tail = node;
            }
        }
        
        public void moveToTail(Node node) {
            if (this.tail == node)
                return;
            else {
                if (this.head == node) {
                    node.next.last = null;
                    this.head = node.next;
                } else {
                    node.next.last = node.last;
                    node.last.next = node.next;
                }
                this.tail.next = node;
                node.last = this.tail;
                this.tail = node;
            }
        }
        
    }
    
    public LRUCache(int capacity) {
        this.mapKeyToNode = new HashMap<>();
        this.mapNodeToKey = new HashMap<>();
        this.doubleLinkedList = new DoubleLinkedList();
        if (capacity < 1)
            throw new RuntimeException("Capacity error");
        this.size = capacity;
    }
    
    public int get(int key) {
        if (!mapKeyToNode.containsKey(key))
            return -1;
        else {
            Node node = mapKeyToNode.get(key);
            this.doubleLinkedList.moveToTail(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if (!mapKeyToNode.containsKey(key)) {
            Node node = new Node(value);
            mapKeyToNode.put(key, node);
            mapNodeToKey.put(node, key);
            this.doubleLinkedList.addTail(node);
            
        } else {
            Node n = mapKeyToNode.get(key);
            if (value != n.value) {
                n.value = value;
            }
            this.doubleLinkedList.moveToTail(n);
        }
        
        if (mapKeyToNode.size() > this.size) {
            Node n = this.doubleLinkedList.removeHead();
            int k = mapNodeToKey.get(n);
            mapKeyToNode.remove(k);
            mapNodeToKey.remove(n);
        }
    }
    
    public static void main(String[] args) {
        
        LRUCache cache = new LRUCache(2);
        
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        System.out.println(cache.get(2));
        
        //        cache.put(1, 1);
        //        cache.put(2, 2);
        //        System.out.println(cache.get(1)); // 返回  1
        //        cache.put(3, 3); // 该操作会使得密钥 2 作废
        //        System.out.println(cache.get(2)); // 返回 -1 (未找到)
        //        cache.put(4, 4); // 该操作会使得密钥 1 作废
        //        System.out.println(cache.get(1)); // 返回 -1 (未找到)
        //        System.out.println(cache.get(3)); // 返回  3
        //        System.out.println(cache.get(4)); // 返回  4
        
        //        cache.put(1, 1); //1
        //        cache.put(2, 2); //1,2
        //        cache.put(3, 3); //1,2,3
        //        System.out.println(cache.get(1));//2,3,1
        //        cache.put(2, 2); //3,1,2
        //        System.out.println(cache.get(3));//1,2,3
        //        cache.put(4, 4); //2,3,4
        //        System.out.println(cache.get(1));//-1
        //        System.out.println(cache.get(3));//2,4,3
        //        cache.put(5, 5); //4,3,5
        //        System.out.println(cache.get(2));//-1
        //        System.out.println(cache.get(4));//3,5,4
        
        //        cache.put(2, 1);
        //        System.out.println(cache.get(2));
        //        cache.put(3, 2);
        //        System.out.println(cache.get(2));
        //        System.out.println(cache.get(3));
        
    }
}
