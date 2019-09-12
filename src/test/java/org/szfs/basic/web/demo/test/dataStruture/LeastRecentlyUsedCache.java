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
public class LeastRecentlyUsedCache<V> {
    
    private HashMap<String, String>  map       = new HashMap<>();
    
    private HashMap<String, Node<V>> keyToNode = new HashMap<>();
    
    private HashMap<Node<V>, String> nodeToKey = new HashMap<>();
    
    private int                      size;
    
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
            this.tail.next = node;
            node.last = this.tail;
            tail = node;
        }
        
        public void moveToTail(Node<V> node) {
            if (node == tail)
                return;
            if (node == head) {
                this.head.next.last = null;
                this.head.next = null;
            } else {
                node.next.last = node.last;
                node.last.next = node.next;
            }
            node.last = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
        
        public Node<V> removeHead() {
            if (this.head == null)
                return null;
            
            this.head = this.head.next;
            this.head.last = null;
            return this.head;
        }
        
    }
    
    public LeastRecentlyUsedCache(int size) {
        this.size = size;
    }
    
    public void set(String key, String value) {
    }
    
    public String get(String key) {
        
        return null;
    }
    
}
