package cn.fivejoy.dsa.jianzhi;

import cn.fivejoy.dsa.jianzhi.common.ListNode;

/**
 * @description: 15 链表中的倒数第k个节点
 * 输入链表，输出链表的倒数第k个节点
 *
 * 情况：
 * 参数检查：
 *  链表为空
 *  K<=0
 *
 * 链表长度不足k? 返回null
 * 链表正常，怎么找到倒数第k
 * 快慢节点，快指针先走k步，随后快慢一起，当这个到头，慢指针指向的位置。
 * @author: liululu
 * @create: 2019/10/21 20:42
 */
public class Jno15 {
    public static ListNode returnLastKListNode(ListNode head,int k){
        if(head==null||k<=0){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        int count=1;
        while(fast!=null&&count<=k){
            fast=fast.next;
        }
        if(fast.next==null&&count<k){
            return null;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

}
