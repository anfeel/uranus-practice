package problems.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 *
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1, 5, 2]
 * 输出：False
 * 解释：一开始，玩家1可以从1和2中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 False 。
 * 示例 2：
 *
 * 输入：[1, 5, 233, 7]
 * 输出：True
 * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
 *      最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
 *
 * 输入：[1, 2, 3, 4, 5, 6, 7]
 * True
 * 输入：[1, 2, 3, 234, 5, 6, 7]
 * False
 * 输入：[1, 2, 3, 4, 345, 6, 7]
 * True
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/predict-the-winner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:PredictWinner, v 0.1 2020年09月01日 8:30 anfeel Exp $
 */
public class PredictWinner {

    public boolean predictTheWinner(int[] nums) {
        int p1 = 0, p2 = 0;
        boolean[] res = new boolean[1];
        chooseNumber(nums, p1, p2, 0, 1, nums.length - 1, true, res);
        chooseNumber(nums, p1, p2, nums.length - 1, 0, nums.length - 2, true, res);
        return res[0];
    }

    public void chooseNumber(int[] nums, int sum1, int sum2, int next, int begin, int end, boolean player, boolean[] res) {
        if (begin - 1 > end) {
            if (sum1 >= sum2 && !res[0])
                res[0] = true;
            return;
        }
        if (player)
            sum1 += nums[next];
        else
            sum2 += nums[next];
        if (begin + 1 == end && nums[begin] > nums[end])
            chooseNumber(nums, sum1, sum2, begin, begin + 1, end, !player, res);
        else if (begin + 1 == end && nums[begin] < nums[end])
            chooseNumber(nums, sum1, sum2, end, begin, end - 1, !player, res);
        else {
            chooseNumber(nums, sum1, sum2, begin, begin + 1, end, !player, res);
            chooseNumber(nums, sum1, sum2, end, begin, end - 1, !player, res);
        }
    }

    @Test
    public void test1() {
        int[] arr = {1, 5, 2};
        Assert.assertFalse(predictTheWinner(arr));
    }

    @Test
    public void test2() {
        int[] arr = {1, 5, 233, 7};
        Assert.assertTrue(predictTheWinner(arr));
    }


    @Test
    public void test3() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Assert.assertTrue(predictTheWinner(arr));
    }

    @Test
    public void test4() {
        int[] arr = {1, 2, 3, 234, 5, 6, 7};
        Assert.assertFalse(predictTheWinner(arr));
    }

    @Test
    public void test5() {
        int[] arr = {1, 2, 3, 4, 345, 6, 7};
        Assert.assertTrue(predictTheWinner(arr));
    }

    @Test
    public void test6() {
        int[] arr = {1, 2, 3, 4, 5, 345, 7};
        Assert.assertTrue(predictTheWinner(arr));
    }

    @Test
    public void test7() {
        int[] arr = {1, 2, 3, 4, 5, 6, 345};
        Assert.assertTrue(predictTheWinner(arr));
    }

    @Test
    public void test8() {
        int[] arr = {1};
        Assert.assertTrue(predictTheWinner(arr));
    }
}
