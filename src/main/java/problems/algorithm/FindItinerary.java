package problems.algorithm;

import org.junit.Test;

import java.util.*;

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

    /**
     * 第三种思路：遇到死结点才插入，否则深度搜索
     * @param tickets
     * @return
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> flight : tickets) {
            String source = flight.get(0);
            String target = flight.get(1);
            if (!map.containsKey(source)) {
                List<String> list = new LinkedList<>();
                list.add(target);
                map.put(source, list);
            } else {
                List<String> list = map.get(source);
                list.add(target);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareToIgnoreCase(o2);
                }
            });
        }
        getPath(map, "JFK", res);
        return res;
    }

    public void getPath(Map<String, List<String>> map, String source, List<String> res) {
        List<String> dest = map.get(source);
        while (dest != null && dest.size() > 0) {
            String target = dest.remove(0);
            getPath(map, target, res);
        }
        res.add(0, source);
    }


    /**
     * 第二种思路：深度搜索出所有符合条件的路线，依次比较字母顺序
     * @param tickets
     * @return
     */
    public List<String> findItinerary4(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        if (tickets.size() == 0)
            return res;
        String begin = "JFK";
        //Stack<String> stack: 记录已使用的机票
        Stack<String> stack = new Stack<>();
        stack.push(begin);
        //boolean[] status:标识机票是否已加入安排
        findFlight(begin, stack, new boolean[tickets.size()], tickets, res);
        return res;
    }

    public void findFlight(String source, Stack<String> stack, boolean[] status, List<List<String>> tickets, List<String> res) {
        if (stack.size() == tickets.size() + 1) {
            if (res.size() == 0)
                res.addAll(new ArrayList<>(stack));
            else {
                List<String> newList = new ArrayList<>(stack);
                for (int i = 0; i < newList.size(); i++) {
                    String ori = res.get(i);
                    String cur = newList.get(i);
                    if (cur.compareToIgnoreCase(ori) < 0) {
                        res.clear();
                        res.addAll(newList);
                        break;
                    } else if (cur.compareToIgnoreCase(ori) > 0)
                        break;
                }
            }
            return;
        }
        for (int i = 0; i < tickets.size(); i++) {
            List<String> curFlight = tickets.get(i);
            if (!status[i] && curFlight.get(0).equals(source)) {
                String target = curFlight.get(1);
                stack.push(target);
                status[i] = true;
                findFlight(target, stack, status, tickets, res);
                stack.pop();
                status[i] = false;
            }
        }
    }

    /**
     * 第一种思路：先查找当前降落点字母顺序最小的航班，若安排失败，则将该航班在当前层次置为不可安排；
     * @param tickets
     * @return
     */
    public List<String> findItinerary3(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        if (tickets.size() == 0)
            return res;
        String begin = "JFK";
        //Stack<String> stack: 记录已使用的机票
        Stack<String> stack = new Stack<>();
        stack.push(begin);
        //boolean[] fail: 记录因安排行程失败的机票
        List<boolean[]> list = new ArrayList<>();
        //boolean[] status:标识机票是否已加入安排
        findPath(begin, "", stack, new boolean[tickets.size()], tickets, res, new boolean[tickets.size()]);
        return res;
    }

    public boolean findPath(String source, String last, Stack<String> stack, boolean[] status, List<List<String>> tickets, List<String> res, boolean[] fail) {
        if (stack.size() == tickets.size() + 1) {
            res.addAll(new ArrayList<>(stack));
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            List<String> curFlight = tickets.get(i);
            if (!fail[i] && !status[i] && curFlight.get(0).equals(source)) {
                String target = curFlight.get(1);
                //查找当前字母
                if (last == "" || last.compareToIgnoreCase(target) > 0) {
                    last = target;
                    stack.push(target);
                    status[i] = true;
                    boolean flag = findPath(target, last, stack, status, tickets, res, new boolean[tickets.size()]);
                    if (!flag) {
                        stack.pop();
                        fail[i] = true;
                        status[i] = false;
                    }
                }
            }
        }
        return false;
    }

    public List<String> findItinerary2(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        if (tickets.size() == 0)
            return res;
        //设置状态数组boolean status[]:标识机票是否已加入排序
        boolean[] status = new boolean[tickets.size()];
        //设置路线栈stack<Integer> stack:标识已使用的航班
        Stack<Integer> stack = new Stack<>();
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
            } else {
                if (res.size() == tickets.size() + 1)
                    break;
            }
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

    /**
     * 输入: [["JFK","SHZ"],["JFK","SHA"],["SHZ","CHQ"],["CHQ","JFK"],["SHA","HAZ"],["HAZ","JFK"]]
     * 输出: ["JFK","SHA","HAZ","JFK","SHZ","CHQ","JFK"]
     */
    @Test
    public void test8() {
        List<String> flight1 = new ArrayList<>(Arrays.asList("JFK", "SHZ"));
        List<String> flight2 = new ArrayList<>(Arrays.asList("JFK", "SHA"));
        List<String> flight3 = new ArrayList<>(Arrays.asList("SHZ", "CHQ"));
        List<String> flight4 = new ArrayList<>(Arrays.asList("SHA", "HAZ"));
        List<String> flight5 = new ArrayList<>(Arrays.asList("CHQ", "JFK"));
        List<String> flight6 = new ArrayList<>(Arrays.asList("HAZ", "JFK"));
        List<List<String>> fly = new ArrayList<>(Arrays.asList(flight1, flight2, flight3, flight4, flight5, flight6));
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
    public void test9() {
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

    @Test
    public void testa() {
        String a = "Ba";
        String b = "bc";
        System.out.println(a.compareToIgnoreCase(b));
    }

    @Test
    public void testb() {
        List<String> flight1 = new ArrayList<>(Arrays.asList("JFK", "SHZ", "CHQ"));
        List<String> flight2 = new ArrayList<>(Arrays.asList("JFK", "SHA", "CHQ"));
        compareStr(flight1, flight2);
        for (String str : flight2
        ) {
            System.out.print(" " + str);
        }
    }

    public void compareStr(List<String> flight1, List<String> flight2) {
        for (int i = 0; i < flight2.size(); i++) {
            String ori = flight1.get(i);
            String cur = flight2.get(i);
            if (ori.compareToIgnoreCase(cur) < 0) {
                flight1 = flight2;
                break;
            }
        }
    }
}
