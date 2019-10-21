package cn.fivejoy.dsa.jianzhi;

import cn.fivejoy.dsa.jianzhi.common.ListNode;
import cn.fivejoy.dsa.jianzhi.util.ListUtil;

import java.util.List;

/**
 * @description: 16 反转链表
 * 参数检查
 * 空链表
 * <p>
 * 特殊情况
 * 一个节点
 * <p>
 * 方法：
 * 1.怼栈里
 * 2.
 * next---断掉节点前先保存
 * pre,cur,next三个指针，next是用来留存的，主要是pre和cur进行指针变换
 * @author: liululu
 * @create: 2019/10/21 20:56
 */
public class Jno16 {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            next=cur.next;//留存

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    public static void main(String[] args) {
        ListNode head= ListUtil.makeList();
        ListUtil.printList(head);
        ListUtil.printList(reverseList(head));
    }
}
