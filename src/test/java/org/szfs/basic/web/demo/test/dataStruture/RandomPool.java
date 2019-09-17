package org.szfs.basic.web.demo.test.dataStruture;

import java.util.HashMap;

/**
 * 设计一种结构，在该结构下有三个功能：
 * insert(key): 将某个key加入到该结构，做到不重复加入
 * delete(key): 将原本在结构中的某个key移除
 * getRandom(): 等概率随机返回结构中的任何一个key
 * insert, delete, getRandom的时间复杂度都是O(1)
 * @author prd-fuy
 * @version $Id: RandomPool.java, v 0.1 2019年9月17日 下午3:55:39 prd-fuy Exp $
 */
public class RandomPool<K> {
    
    private HashMap<K, Integer> keyMap;
    
    private HashMap<Integer, K> indexMap;
    
    private int                 i;
    
    public RandomPool() {
        this.keyMap = new HashMap<>();
        this.indexMap = new HashMap<>();
        this.i = 0;
    }
    
    public void insert(K key) {
        if (keyMap.containsKey(key)) {
            System.out.println("The key is already exist");
        } else {
            keyMap.put(key, i++);
            indexMap.put(i, key);
        }
    }
    
    public void delete(K key) {
        if (!keyMap.containsKey(key)) {
            System.out.println("The key doesn't exists");
        } else {
            int index = keyMap.get(key);
            keyMap.remove(key);
            indexMap.remove(index);
        }
    }
    
    public K getRandom() {
        return null;
    }
}