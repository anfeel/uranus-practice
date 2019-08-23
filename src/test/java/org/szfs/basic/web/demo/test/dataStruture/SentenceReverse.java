package org.szfs.basic.web.demo.test.dataStruture;

import org.junit.Test;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author prd-fuy
 * @version $Id: SentenceReverse.java, v 0.1 2019年8月27日 上午10:50:10 prd-fuy Exp $
 */
public class SentenceReverse {
    
    public String ReverseSentence(String str) {
        if (str == null || str.trim().equals(""))
            return str;
        String[] array = str.split(" ");
        String ret = "";
        for (int i = array.length - 1; i >= 0; i--) {
            ret += array[i];
            if (i != 0)
                ret += " ";
        }
        return ret;
    }
    
    @Test
    public void test1() {
        String str = "student. a am I";
        System.out.println(str);
        String ret = ReverseSentence(str);
        System.out.println(ret);
    }
    
    @Test
    public void test2() {
        String str = "";
        System.out.println(str);
        String ret = ReverseSentence(str);
        System.out.println(ret);
    }
    
    @Test
    public void test3() {
        String str = null;
        System.out.println(str);
        String ret = ReverseSentence(str);
        System.out.println(ret);
    }
    
    @Test
    public void test4() {
        String str = "sentenceReverse";
        System.out.println(str);
        String ret = ReverseSentence(str);
        System.out.println(ret);
    }
    
    @Test
    public void test5() {
        String str = "s e n t e n c  eR e v e r s e";
        System.out.println(str);
        String ret = ReverseSentence(str);
        System.out.println(ret);
    }
    
    @Test
    public void test6() {
        String str = "   sent 12 ";
        System.out.println(str);
        String ret = ReverseSentence(str);
        System.out.println(ret);
    }
    
    @Test
    public void test7() {
        String str = " s e n t e n c  eR e v e r s e";
        System.out.println(str);
        String ret = ReverseSentence(str);
        System.out.println(ret);
    }
}
