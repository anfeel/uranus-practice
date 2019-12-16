package org.szfs.basic.web.demo.test.dataStruture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author anfeel
 * @version $Id: distinctTest.java, v 0.1 2019年12月16日 下午4:18:02 anfeel Exp $
 */
public class distinctTest {

    public List<Integer> distinct(List<Integer> list, List<Integer> newList) {
        if (list.size() < 8) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i : list) {
                map.put(i, 1);
            }
            for (int j = 0; j < newList.size(); j++) {
                int tmp = newList.get(j);
                if (!map.containsKey(tmp)) {
                    list.add(tmp);
                }
            }
        }
        return list;
    }

    public void print(List<Integer> list) {
        System.out.println();
        for (int i : list) {
            System.out.printf(" %d ", i);
        }
    }

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        print(list);
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(6);
        newList.add(2);
        newList.add(7);
        newList.add(4);
        newList.add(5);
        newList.add(8);
        newList.add(9);
        print(newList);
        list = distinct(list, newList);
        print(list);
    }
}
