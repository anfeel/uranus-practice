package problems.algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:TopKFrequent, v 0.1 2020年09月02日 17:13 anfeel Exp $
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length)
            return new int[]{};
        Map<Integer, Integer> mapNum2Count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mapNum2Count.containsKey(nums[i])) {
                int count = mapNum2Count.get(nums[i]);
                mapNum2Count.put(nums[i], count + 1);
            } else {
                mapNum2Count.put(nums[i], 1);
            }
        }
        Data[] data = new Data[mapNum2Count.size()];
        int c = 0;
        for (Map.Entry<Integer, Integer> entry : mapNum2Count.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            Data d = new Data(num, count);
            data[c++] = d;
        }
        heapSort(data, data.length);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = data[data.length - 1 - i].getNum();
        }
        return res;
    }

    public void heapSort(Data[] tree, int len) {
        buildHeap(tree, len);
        for (int i = len - 1; i >= 1; i--) {
            swap(tree, 0, i);
            buildHeap(tree, i);
        }
    }

    public void buildHeap(Data[] tree, int len) {
        int last = len - 1;
        int parent = (last - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(tree, len, i);
        }
    }

    public void heapify(Data[] tree, int len, int i) {
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        int max = i;
        if (c1 < len && tree[c1].getCount() > tree[max].getCount())
            max = c1;
        if (c2 < len && tree[c2].getCount() > tree[max].getCount())
            max = c2;
        if (max != i) {
            swap(tree, max, i);
            heapify(tree, len, max);
        }
    }

    public void swap(Data[] tree, int i, int j) {
        Data tmp = tree[i];
        tree[i] = tree[j];
        tree[j] = tmp;
    }


    @Test
    public void test1() {
        int[] res = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
    }

    @Test
    public void test2() {
        int[] res = topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 3, 4, 4, 4}, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
    }

    @Test
    public void test3() {
        int[] res = topKFrequent(new int[]{}, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
    }

    @Test
    public void test4() {
        int[] res = topKFrequent(null, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
    }

    @Test
    public void test5() {
        int[] res = topKFrequent(new int[]{1}, 1);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
    }

    @Test
    public void test6() {
        int[] res = topKFrequent(new int[]{1, 2}, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
    }

    @Test
    public void test7() {
        int[] res = topKFrequent(new int[]{2, 1}, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
    }

    @Test
    public void test8() {
        int[] res = topKFrequent(new int[]{3, 2, 1}, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
    }


}

class Data {
    private int num;
    private int count;

    public Data(int num, int count) {
        this.num = num;
        this.count = count;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
