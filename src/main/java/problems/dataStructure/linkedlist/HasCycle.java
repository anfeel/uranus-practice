package problems.dataStructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * 示例 1：

    输入：head = [3,2,0,-4], pos = 1
    输出：true
    解释：链表中有一个环，其尾部连接到第二个节点。
    
    示例 2：
    
    输入：head = [1,2], pos = 0
    输出：true
    解释：链表中有一个环，其尾部连接到第一个节点。
    
    示例 3：
    
    输入：head = [1], pos = -1
    输出：false
    解释：链表中没有环。
    
    进阶：
    
    你能用 O(1)（即，常量）内存解决此问题吗？
    
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/linked-list-cycle
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author anfeel
 * @version $Id: HasCycle.java, v 0.1 2019年12月17日 上午10:51:56 anfeel Exp $
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode p = head;
        ListNode q = head.next;
        while (p != q) {
            if (q == null || q.next == null)
                return false;
            p = p.next;
            q = q.next.next;
        }
        return true;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
            } else
                return true;
            head = head.next;
        }
        return false;
    }

    @Test
    public void test1() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;
        p1_3.next = p1_2;
        Assert.assertTrue(hasCycle(p1_1));
    }

    @Test
    public void test2() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;
        Assert.assertFalse(hasCycle(p1_1));
    }

    @Test
    public void test3() {
        Assert.assertFalse(hasCycle(null));
    }

    @Test
    public void test4() {
        ListNode p1_1 = new ListNode(1);
        Assert.assertFalse(hasCycle(p1_1));
    }

    @Test
    public void test5() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        ListNode p1_3 = new ListNode(3);
        p1_2.next = p1_3;
        p1_3.next = p1_1;
        Assert.assertTrue(hasCycle(p1_1));
    }

    @Test
    public void test6() {
        ListNode p1_1 = new ListNode(1);
        ListNode p1_2 = new ListNode(2);
        p1_1.next = p1_2;
        Assert.assertFalse(hasCycle(p1_1));
    }
}
