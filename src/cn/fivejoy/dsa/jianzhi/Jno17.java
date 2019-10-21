package cn.fivejoy.dsa.jianzhi;

import cn.fivejoy.dsa.jianzhi.common.ListNode;
import cn.fivejoy.dsa.jianzhi.util.ListUtil;

/**
 * @description: 17 合并两个排序的链表
 * 输入参数检查：
 * 都是空/部分为空
 * 特殊情况：
 * @author: liululu
 * @create: 2019/10/21 21:33
 */
public class Jno17 {
    public static ListNode mergeTwoSortedList(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head3 = null;
        ListNode p1 = head1, p2 = head2;
        if (p1.value < p2.value) {
            head3 = p1;
            head3.next = mergeTwoSortedList(p1.next, p2);
        } else {
            head3 = p2;
            head3.next = mergeTwoSortedList(p1, p2.next);
        }
        return head3;
    }

    public static void main(String[] args) {
        ListNode head1 = ListUtil.makeRandomSortedList(5, 20);
        ListUtil.printList(head1);
        ListNode head2 = ListUtil.makeRandomSortedList(6, 19);
        ListUtil.printList(head2);
        ListUtil.printList(mergeTwoSortedList(null, null));
    }

}
