package org.szfs.basic.web.demo.test.dataStruture;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author anfeel
 * @version $ Id:CompareTest, v 0.1 2020年03月07日 15:37 anfeel Exp $
 */
public class StringCompareTest {

    public static String getCharAndNumr(int length) {

        Random random = new Random();

        StringBuffer valSb = new StringBuffer();

        String charStr = "0123456789abcdefghijklmnopqrstuvwxyz";

        int charLength = charStr.length();


        for (int i = 0; i < length; i++) {

            int index = random.nextInt(charLength);

            valSb.append(charStr.charAt(index));

        }

        return valSb.toString();

    }


    @Test
    public void test() {
        List<String> list = new ArrayList<>(1000000);
        for (int i = 0; i < 1000000; i++) {
            String t = getCharAndNumr(60);
            list.add(t);
        }
        System.out.println("begin  time : " + new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null || o2 == null) {
                    return -1;
                }
                if (o1.length() > o2.length()) {
                    return 1;
                }
                if (o1.length() < o2.length()) {
                    return -1;
                }
                if (o1.compareTo(o2) > 0) {
                    return 1;
                }
                if (o1.compareTo(o2) < 0) {
                    return -1;
                }
                if (o1.compareTo(o2) == 0) {
                    return 0;
                }
                return 0;
            }
        });
        System.out.println("end  time : " + new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
    }


}
