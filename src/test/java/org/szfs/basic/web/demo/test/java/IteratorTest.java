package org.szfs.basic.web.demo.test.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author anfeel
 * @version $ Id:IteratorTest, v 0.1 2020年03月18日 15:48 anfeel Exp $
 */
public class IteratorTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(i);
            System.out.println(i);
        }
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            Integer j = iterator.next();
            if (j % 5 == 0) {
                iterator.remove();
                continue;
            }
            System.out.println(j);
        }
    }
}
