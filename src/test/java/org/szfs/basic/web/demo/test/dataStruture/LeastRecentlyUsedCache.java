package org.szfs.basic.web.demo.test.dataStruture;

import java.util.HashMap;

/**
 * 可以变更的缓存结构
 * 设计一种缓存结构，该结构在构造时确定大小，假设大小为K，并有两个功能：
 * set(key,value):将记录(key,value)插入该结构
 * get(key):返回key对应的value值
 * 1.set和get方法的时间复杂度为O(1)
 * 2.某个key的set或get操作一旦发生，认为这个key的记录成了最经常使用的
 * 3.当缓存的大小超过k时，移除最不经常使用的记录，即set或get最久远的
 * @author prd-fuy
 * @version $Id: LeastRecentlyUsedCache.java, v 0.1 2019年9月12日 下午2:53:20 prd-fuy Exp $
 * @param <V>
 */
public class LeastRecentlyUsedCache<K, V> {
    
    private HashMap<K, Node<V>>  keyToNode;
    
    private HashMap<Node<V>, K>  nodeToKey;
    
    private NodeDoubleLinkedList linkedList;
    
    private int                  capacity;
    
    class Node<V> {
        public V       value;
        public Node<V> last;
        public Node<V> next;
        
        public Node(V value) {
            this.value = value;
        }
    }
    
    class NodeDoubleLinkedList {
        private Node<V> head;
        private Node<V> tail;
        
        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }
        
        public void addNode(Node<V> node) {
            if (node == null)
                return;
            if (this.head == null) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.next = node;
                node.last = this.tail;
                tail = node;
            }
        }
        
        public void moveToTail(Node<V> node) {
            if (node == tail)
                return;
            if (node == head) {
                this.head = node.next;
                this.head.last = null;
            } else {
                node.next.last = node.last;
                node.last.next = node.next;
            }
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }
        
        public Node<V> removeHead() {
            if (this.head == null)
                return null;
            Node<V> node = this.head.next;
            this.head.next = null;
            node.last = null;
            this.head = node;
            return this.head;
        }
        
    }
    
    public LeastRecentlyUsedCache(int capacity) {
        if (capacity <= 1)
            throw new RuntimeException("capacity cannot lower than 1..");
        this.capacity = capacity;
        this.keyToNode = new HashMap<>();
        this.nodeToKey = new HashMap<>();
        this.linkedList = new NodeDoubleLinkedList();
    }
    
    public void set(K key, V value) {
        if (keyToNode.containsKey(key)) {
            Node<V> node = keyToNode.get(key);
            node.value = value;
            linkedList.moveToTail(node);
            keyToNode.put(key, node);
            nodeToKey.put(node, key);
        } else {
            if (keyToNode.size() == this.capacity) {
                removeRecentlyUnused();
            }
            Node<V> node = new Node<V>(value);
            linkedList.addNode(node);
            keyToNode.put(key, node);
            nodeToKey.put(node, key);
        }
    }
    
    public V get(K key) {
        if (!keyToNode.containsKey(key))
            return null;
        else {
            Node<V> node = keyToNode.get(key);
            linkedList.moveToTail(node);
            return keyToNode.get(key).value;
        }
    }
    
    public void removeRecentlyUnused() {
        if (linkedList.head == null)
            return;
        else {
            Node<V> node = linkedList.removeHead();
            K key = nodeToKey.get(node);
            keyToNode.remove(key);
            nodeToKey.remove(node);
        }
    }
    
    public static void main(String[] args) {
        LeastRecentlyUsedCache<String, Integer> cache = new LeastRecentlyUsedCache<>(3);
        cache.set("A", 1);
        cache.set("B", 2);
        cache.set("C", 3);
        int i = cache.get("A");
        cache.set("D", 4);
        int j = 0;
    }
    
}
