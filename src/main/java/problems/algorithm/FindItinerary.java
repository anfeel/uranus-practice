package problems.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 * 说明:
 *
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 *
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 *
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:FindItinerary, v 0.1 2020年08月27日 7:39 anfeel Exp $
 */
public class FindItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        //设置状态数组boolean status[]:标识机票是否已加入排序
        boolean[] status = new boolean[tickets.size()];
        List<String> res = new ArrayList<>();
        if (tickets.size() == 0)
            return res;
        String begin = "JFK";
        res.add(begin);
        while (true) {
            String cur = "";
            int last = 0;
            for (int i = 0; i < tickets.size(); i++) {
                if (!status[i]) {
                    List<String> single = tickets.get(i);
                    if (single.get(0).equals(begin)) {
                        if (cur == "") {
                            cur = single.get(1);
                            status[i] = true;
                            last = i;
                        } else {
                            if (cur.compareToIgnoreCase(single.get(1)) > 0) {
                                cur = single.get(1);
                                status[last] = false;
                                status[i] = true;
                            }
                        }
                    }
                }
            }
            if (cur != "") {
                res.add(cur);
                begin = cur;
            } else
                break;
        }
        return res;
    }

    /**
     * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
     */
    @Test
    public void test1() {
        List<String> flight1 = new ArrayList<>(Arrays.asList("MUC", "LHR"));
        List<String> flight2 = new ArrayList<>(Arrays.asList("JFK", "MUC"));
        List<String> flight3 = new ArrayList<>(Arrays.asList("SFO", "SJC"));
        List<String> flight4 = new ArrayList<>(Arrays.asList("LHR", "SFO"));
        List<List<String>> fly = new ArrayList<>(Arrays.asList(flight1, flight2, flight3, flight4));
        List<String> res = findItinerary(fly);
        for (String s : res) {
            System.out.print(" " + s);
        }
    }

    /**
     * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
     */
    @Test
    public void test2() {
        List<String> flight1 = new ArrayList<>(Arrays.asList("JFK", "SFO"));
        List<String> flight2 = new ArrayList<>(Arrays.asList("JFK", "ATL"));
        List<String> flight3 = new ArrayList<>(Arrays.asList("SFO", "ATL"));
        List<String> flight4 = new ArrayList<>(Arrays.asList("ATL", "JFK"));
        List<String> flight5 = new ArrayList<>(Arrays.asList("ATL", "SFO"));
        List<List<String>> fly = new ArrayList<>(Arrays.asList(flight1, flight2, flight3, flight4, flight5));
        List<String> res = findItinerary(fly);
        for (String s : res) {
            System.out.print(" " + s);
        }
    }

    /**
     * 输入: [["JFK","SFO"]]
     * 输出: ["JFK","SFO"]
     */
    @Test
    public void test3() {
        List<String> flight1 = new ArrayList<>(Arrays.asList("JFK", "SFO"));
        List<List<String>> fly = new ArrayList<>(Arrays.asList(flight1));
        List<String> res = findItinerary(fly);
        for (String s : res) {
            System.out.print(" " + s);
        }
    }


    /**
     * 输入: []
     * 输出: []
     */
    @Test
    public void test4() {
        List<String> flight1 = new ArrayList<>(Arrays.asList("JFK", "SFO"));
        List<List<String>> fly = new ArrayList<>();
        List<String> res = findItinerary(fly);
        for (String s : res) {
            System.out.print(" " + s);
        }
    }

    /**
     * 输入: [["JFK","SFO"],["SFO", "JFK"],["JFK", "SFO"],["SFO", "JFK"]]
     * 输出: ["JFK","SFO","JFK","SFO","JFK"]
     */
    @Test
    public void test5() {
        List<String> flight1 = new ArrayList<>(Arrays.asList("JFK", "SFO"));
        List<String> flight2 = new ArrayList<>(Arrays.asList("SFO", "JFK"));
        List<String> flight3 = new ArrayList<>(Arrays.asList("JFK", "SFO"));
        List<String> flight4 = new ArrayList<>(Arrays.asList("SFO", "JFK"));
        List<List<String>> fly = new ArrayList<>(Arrays.asList(flight1, flight2, flight3, flight4));
        List<String> res = findItinerary(fly);
        for (String s : res) {
            System.out.print(" " + s);
        }
    }


    /**
     * 输入: [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
     * 输出: ["JFK","MUC","LHR","SFO","SJC"]
     */
    @Test
    public void test6() {
        List<String> flight1 = new ArrayList<>(Arrays.asList("MUC", "LHR"));
        List<String> flight2 = new ArrayList<>(Arrays.asList("JFK", "MUC"));
        List<String> flight3 = new ArrayList<>(Arrays.asList("SFO", "SJC"));
        List<String> flight4 = new ArrayList<>(Arrays.asList("LHR", "SFO"));
        List<List<String>> fly = new ArrayList<>(Arrays.asList(flight1, flight2, flight3, flight4));
        List<String> res = findItinerary(fly);
        for (String s : res) {
            System.out.print(" " + s);
        }
    }

    /**
     * 输入: [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
     * 输出: ["JFK","NRT","JFK","KUL"]
     */
    @Test
    public void test7() {
        List<String> flight1 = new ArrayList<>(Arrays.asList("JFK", "KUL"));
        List<String> flight2 = new ArrayList<>(Arrays.asList("JFK", "NRT"));
        List<String> flight3 = new ArrayList<>(Arrays.asList("NRT", "JFK"));
        List<List<String>> fly = new ArrayList<>(Arrays.asList(flight1, flight2, flight3));
        List<String> res = findItinerary(fly);
        for (String s : res) {
            System.out.print(" " + s);
        }
    }

    @Test
    public void testa() {
        String a = "BC";
        String b = "bc";
        System.out.println(a.compareToIgnoreCase(b));
    }
}
