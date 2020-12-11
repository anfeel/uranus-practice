package problems.dataStructure.array;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:DailyTemperatures, v 0.1 2020年12月11日 10:23 anfeel Exp $
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if (T == null | T.length == 0)
            return new int[]{};
        int[] result = new int[T.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(T.length - 1);
        for (int i = T.length - 1; i >= 0; i--) {
            if (T[i] >= T[deque.peekFirst()]) {
                deque = new LinkedList<>();
                deque.offerFirst(i);
                result[i] = deque.peekLast() - i;
            } else {
                while (T[i] >= T[deque.peekLast()]) {
                    deque.pollLast();
                }
                result[i] = deque.peekLast() - i;
                deque.offerLast(i);
            }
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    @Test
    public void test2() {
        int[] arr = {79, 78, 77, 76, 75, 74, 73, 72, 71, 70};
        int[] res = dailyTemperatures(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    @Test
    public void test3() {
        int[] arr = {74, 73, 72, 71, 70, 79, 78, 77, 76, 75};
        int[] res = dailyTemperatures(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    @Test
    public void test4() {
        int[] arr = {71, 70, 74, 73, 72, 77, 76, 75, 79, 78};
        int[] res = dailyTemperatures(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    @Test
    public void test5() {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures2(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    @Test
    public void test6() {
        int[] arr = {79, 78, 77, 76, 75, 74, 73, 72, 71, 70};
        int[] res = dailyTemperatures2(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    @Test
    public void test7() {
        int[] arr = {74, 73, 72, 71, 70, 79, 78, 77, 76, 75};
        int[] res = dailyTemperatures2(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    @Test
    public void test8() {
        int[] arr = {55, 38, 53, 81, 61, 93, 97, 32, 43, 78};
        int[] res = dailyTemperatures(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    @Test
    public void test9() {
        int[] arr = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] res = dailyTemperatures2(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
