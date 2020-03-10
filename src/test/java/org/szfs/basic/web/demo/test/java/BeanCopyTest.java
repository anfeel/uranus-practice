package org.szfs.basic.web.demo.test.java;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 *
 * @author anfeel
 * @version $ Id:BeanCopyTest, v 0.1 2020年03月07日 16:13 anfeel Exp $
 */
public class BeanCopyTest {

    public void getTest(test1 test1, test2 test2) {
        test1.setAaa("123");
        test1.setAab(2);
        saveTest(test1, test2);
    }

    public void saveTest(test1 test1, test2 test2) {
        test2.setAaa("312");
        test2.setAab(3);
    }

    private void saveList(List<String> list) {
        list.add("123");
        list.add("111");
        list.add("223");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        test1 test1 = new test1();
        test2 test2 = new test2();
        BeanCopyTest test = new BeanCopyTest();
        test.getTest(test1, test2);
        System.out.println(test1.getAaa());
        System.out.println(test2.getAaa());
    }
}
