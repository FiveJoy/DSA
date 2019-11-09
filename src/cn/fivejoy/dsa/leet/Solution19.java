package cn.fivejoy.dsa.leet;

import cn.fivejoy.dsa.jianzhi.common.ListNode;
import cn.fivejoy.dsa.jianzhi.util.ListUtil;

import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @author: liulu
 * @create: 2019/11/09 12:47
 * <p>
 * 几个注意的点：
 * 1.不是返回倒数第N个，是删除
 * 2.节点数量=K和<K是不同的情况
 * =K 应该返回head.next
 * <K 应该返回head
 * >K pre.next=slow.next
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        ListNode pre = null;
        for (int i = 1; i <= k; i++) {
            fast = fast.next;
            if (fast == null) {
                if (i == k) {
                    //长度为k
                    return head.next;
                } else {
                    //长度<k
                    return head;
                }
            }
        }
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return head;
    }

    public ListNode Official_removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        ListNode head = ListUtil.makeRandomList(5);
        ListUtil.printList(head);
        //   ListUtil.printList(solution19.Official_removeNthFromEnd(head,6)); 官方题解没有考虑节点数<k的情况
        ListUtil.printList(solution19.removeNthFromEnd(head, 6));

    }

}
