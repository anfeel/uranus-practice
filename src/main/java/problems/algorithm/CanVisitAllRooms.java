package problems.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 *
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 *
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author anfeel
 * @version $ Id:CanVisitAllRooms, v 0.1 2020年08月31日 9:11 anfeel Exp $
 */
public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] status = new boolean[rooms.size()];
        boolean[] res = new boolean[2];
        int[] count = new int[1];
        count[0] = rooms.size() - 1;
        status[0] = true;
        visitRooms(rooms, 0, count, status, res);
        return res[1];
    }

    public void visitRooms(List<List<Integer>> rooms, int next, int[] count, boolean[] status, boolean[] res) {
        List<Integer> list = rooms.get(next);
        for (int j = 0; j < list.size(); j++) {
            int cur = list.get(j);
            if (cur < 0 || cur > status.length - 1 || status[cur])
                continue;
            else {
                count[0]--;
                status[cur] = true;
                visitRooms(rooms, cur, count, status, res);
            }
            if (res[0] || (j == list.size() && count[0] != 0)) {
                res[0] = true;
                return;
            }
        }
        if (count[0] == 0) {
            res[1] = true;
            return;
        }
    }

    @Test
    public void test1() {
        List<Integer> room1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> room2 = new ArrayList<>(Arrays.asList(2));
        List<Integer> room3 = new ArrayList<>(Arrays.asList(3));
        List<Integer> room4 = new ArrayList<>(Arrays.asList());
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1, room2, room3, room4));
        Assert.assertTrue(canVisitAllRooms(rooms));
    }

    @Test
    public void test2() {
        List<Integer> room1 = new ArrayList<>(Arrays.asList(1, 3));
        List<Integer> room2 = new ArrayList<>(Arrays.asList(3, 0, 1));
        List<Integer> room3 = new ArrayList<>(Arrays.asList(2));
        List<Integer> room4 = new ArrayList<>(Arrays.asList());
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1, room2, room3, room4));
        Assert.assertFalse(canVisitAllRooms(rooms));
    }

    @Test
    public void test3() {
        List<Integer> room1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> room2 = new ArrayList<>(Arrays.asList(3, 0, 1));
        List<Integer> room3 = new ArrayList<>(Arrays.asList(2));
        List<Integer> room4 = new ArrayList<>(Arrays.asList());
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1, room2, room3, room4));
        Assert.assertTrue(canVisitAllRooms(rooms));
    }

    @Test
    public void test4() {
        List<Integer> room1 = new ArrayList<>(Arrays.asList(3));
        List<Integer> room2 = new ArrayList<>(Arrays.asList(3, 0, 1));
        List<Integer> room3 = new ArrayList<>(Arrays.asList(3));
        List<Integer> room4 = new ArrayList<>(Arrays.asList());
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1, room2, room3, room4));
        Assert.assertFalse(canVisitAllRooms(rooms));
    }

    @Test
    public void test5() {
        List<Integer> room1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> room2 = new ArrayList<>(Arrays.asList(1));
        List<Integer> room3 = new ArrayList<>(Arrays.asList(1));
        List<Integer> room4 = new ArrayList<>(Arrays.asList(1));
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1, room2, room3, room4));
        Assert.assertFalse(canVisitAllRooms(rooms));
    }


    @Test
    public void test6() {
        List<Integer> room1 = new ArrayList<>();
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1));
        Assert.assertTrue(canVisitAllRooms(rooms));
    }

    @Test
    public void test7() {
        List<Integer> room1 = new ArrayList<>(Arrays.asList(1, 2));
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1));
        Assert.assertTrue(canVisitAllRooms(rooms));
    }

    @Test
    public void test8() {
        List<Integer> room1 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1));
        Assert.assertTrue(canVisitAllRooms(rooms));
    }

    @Test
    public void test9() {
        List<Integer> room1 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1));
        Assert.assertTrue(canVisitAllRooms(rooms));
    }

    @Test
    public void testa() {
        List<Integer> room1 = new ArrayList<>(Arrays.asList(0, 4, 5, 6, 7));
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1));
        Assert.assertTrue(canVisitAllRooms(rooms));
    }

    @Test
    public void testb() {
        List<Integer> room1 = new ArrayList<>(Arrays.asList(0, 4, 5, 6, 7));
        List<Integer> room2 = new ArrayList<>(Arrays.asList(0, 4, 5, 6, 7));
        List<Integer> room3 = new ArrayList<>(Arrays.asList(0, 4, 5, 6, 7));
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1, room2, room3));
        Assert.assertFalse(canVisitAllRooms(rooms));
    }

    @Test
    public void testc() {
        List<Integer> room1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> room2 = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 2));
        List<Integer> room3 = new ArrayList<>(Arrays.asList(0, 4, 5, 6, 7));
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(room1, room2, room3));
        Assert.assertTrue(canVisitAllRooms(rooms));
    }

}
