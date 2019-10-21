package cn.fivejoy.dsa.jianzhi;

import cn.fivejoy.dsa.jianzhi.common.ListNode;
import cn.fivejoy.dsa.jianzhi.util.ListUtil;

import java.util.List;
import java.util.Stack;

/**
 * @description: 从尾到头打印链表
 * 遍历链表，后进先出
 * 每访问一个节点，先递归输出后面的节点，再输出本身
 * @author: liululu
 * @create: 2019/10/20 16:38
 */
public class Jno5 {
    public static void printListReversingly(ListNode head){
        if(head!=null){
        if (head.next!=null){
            printListReversingly(head.next);
        }
            System.out.print(head.value+" ");
        }
    }
    public static void printListReversingly_stact(ListNode head){
        Stack<ListNode> stack=new Stack<>();
        ListNode p=head;
        while (p!=null){
            stack.push(p);
            p=p.next;
        }
        while (!stack.empty()){
            System.out.print(stack.pop().value+" ");
        }
    }

    public static void main(String[] args) {
        printListReversingly_stact(ListUtil.makeList());
    }

}
