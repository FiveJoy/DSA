package cn.fivejoy.dsa.jianzhi;

import cn.fivejoy.dsa.jianzhi.common.ListNode;
import cn.fivejoy.dsa.jianzhi.util.ListUtil;

/**
 * @description: 13  定义方法 O(1)时间删除链表节点
 * 思路：
 * 把要删除的节点的下一个节点复制给要删除的节点，此时要删除的节点就变成下一个节点，
 * 这时候"要删除的节点"的前一节点也找到了，很好删。
 *
 * 要删除的节点是尾结点-直接为Null---直接为null!!有问题！注意虽然Java没有指针，但是实际还是有地址的关系！！head和todelete都是指针实际上
 * 要删除的节点是头结点-head=toDelete.next
 * 要删除的节点是中间的
 * @author: liululu
 * @create: 2019/10/21 20:23
 */

/**
 * --------------tag
 */
public class Jno13 {
    public static void deleteNode(ListNode head,ListNode toDelete){
        if(head==null||toDelete==null){
            return;
        }
        if(head==toDelete){
            head=toDelete.next;
        }
        if(toDelete.next==null){
           //遍历走到最后的节点，才能删掉----
            // 但是最后的时间复杂度是 [(n-1)*O(1)+O(n)]/n 结果还是O(1)
            return;
        }
        ListNode next=toDelete.next;
        toDelete.value=next.value;
        toDelete.next=next.next;
        next=null;
    }

    public static void main(String[] args) {
        ListNode node5=new ListNode(5,null);
        ListNode node4=new ListNode(4,node5);
        ListNode node3=new ListNode(3,node4);
        ListNode node2=new ListNode(2,node3);
        ListNode node1=new ListNode(1,node2);
        ListNode head=node1;
        ListNode toDelete=node5;
        deleteNode(head,toDelete);
        ListUtil.printList(head);

    }
}
