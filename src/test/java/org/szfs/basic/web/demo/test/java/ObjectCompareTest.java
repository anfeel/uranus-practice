package org.szfs.basic.web.demo.test.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author anfeel
 * @version $ Id:ObjectCompareTest, v 0.1 2020年03月10日 9:47 anfeel Exp $
 */
public class ObjectCompareTest {

    public void sort(List<DetailDomain> list) {
        list.sort(new Comparator<DetailDomain>() {
            @Override
            public int compare(DetailDomain o1, DetailDomain o2) {
                if (o1 == null || o2 == null) {
                    return -1;
                }
                if (o1.getContractid().compareTo(o2.getContractid()) > 0) {
                    return 1;
                }
                if (o1.getContractid().compareTo(o2.getContractid()) < 0) {
                    return -1;
                }
                if (o1.getContractid().compareTo(o2.getContractid()) == 0) {
                    if (o1.getMsgid().compareTo(o2.getMsgid()) > 0) {
                        return 1;
                    }
                    if (o1.getMsgid().compareTo(o2.getMsgid()) < 0) {
                        return -1;
                    }
                    if (o1.getMsgid().compareTo(o2.getMsgid()) == 0) {
                        return 0;
                    }
                    return 0;
                }
                return 0;
            }
        });
    }

    public static void main(String[] args) {

        List<DetailDomain> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DetailDomain d = new DetailDomain();
            d.setMsgid(String.valueOf(i));
            d.setContractid(String.valueOf(new Random().nextInt(8)));
            d.setAge(i);
            list.add(d);
            System.out.println(i);
            System.out.println(" msgid: " + d.getMsgid() + " contractid: " + d.getContractid() + " age: " + d.getAge());
        }

        ObjectCompareTest test = new ObjectCompareTest();
        test.sort(list);

        System.out.println(" -------------- sort finished ----------------");

        for (int i = 0; i < 10; i++) {
            DetailDomain d = list.get(i);
            System.out.println(i);
            System.out.println(" msgid: " + d.getMsgid() + " contractid: " + d.getContractid() + " age: " + d.getAge());
        }
    }
}
