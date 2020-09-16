package org.szfs.basic.web.demo.test.dataStruture;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 *
 * @author anfeel
 * @version $ Id:ReferenceTest, v 0.1 2020年02月11日 16:49 anfeel Exp $
 */
public class ReferenceTest {

    @Test
    public void test1() {
        String str = new String("abc");
        SoftReference<String> softRef = new SoftReference<String>(str);
        str = null;
        System.gc();
        System.out.println(softRef.get());

        String str2 = new String("abc");
        WeakReference<String> weakRef = new WeakReference<String>(str2);
        str2 = null;
        System.gc();
        System.out.println(weakRef.get());
    }
}
