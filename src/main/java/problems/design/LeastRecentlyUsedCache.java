package problems.design;

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
        
        /**
         * 新增数据至缓存结构即在链表尾部新增节点
         * @param node
         */
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
        
        /**
         * 用链表结构表示缓存数据使用的频率，即最常使用的节点在尾部，最不常使用的节点在头部
         * 若发生set或get操作，则需调用moveToTail方法将节点移至尾部
         * @param node
         */
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
        
        /**
         * 若新增数据时发现缓存已满，则需移除缓存中最不常使用的数据
         * 该操作即链表结构中移除头部节点
         * @return
         */
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
    
    /**
     * 缓存结构set操作：
     * 1.若结构中包含此key，则更新value，并在链表结构中移至尾部表示最常使用，同时更新两组map
     * 2.若结构中不包含此key，则新增节点至尾部；若发现容量已满，则需先调用removeRecentlyUnused移除最不常使用的节点；
     * @param key
     * @param value
     */
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
    
    /**
     * 缓存结构get操作：
     * 获取缓存数据同时将该数据设为最常使用
     * @param key
     * @return
     */
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
