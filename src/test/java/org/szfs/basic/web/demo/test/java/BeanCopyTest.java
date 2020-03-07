package org.szfs.basic.web.demo.test.java;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author anfeel
 * @version $ Id:BeanCopyTest, v 0.1 2020年03月07日 16:13 anfeel Exp $
 */
public class BeanCopyTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        test1 test1 = new test1();
        test1.setAaa("123");
        test1.setAab(1);
        test2 test2 = new test2();
        BeanUtils.copyProperties(test2, test1);
        System.out.println(" aaa : " + test2.getAaa());
        System.out.println(" aab : " + test2.getAab());
    }
}
