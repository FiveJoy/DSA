package cn.fivejoy.dsa.jianzhi.util;

import cn.fivejoy.dsa.jianzhi.common.ListNode;

import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: liululu
 * @create: 2019/10/20 16:53
 */
public class ListUtil {
    public static ListNode makeList(){
        ListNode node5=new ListNode(5,null);
        ListNode node4=new ListNode(4,node5);
        ListNode node3=new ListNode(3,node4);
        ListNode node2=new ListNode(2,node3);
        ListNode node1=new ListNode(1,node2);
        return node1;
    }
    public static ListNode makeRandomSortedList(int length,int max){

        ListNode tail=new ListNode(max,null);
        ListNode head=null;
        for(int i=1;i<length;i++){
            max=max-randomNum();
            head=new ListNode(max,tail);
            tail=head;

        }
        return head;
    }
    public static ListNode makeRandomList(int length){
        ListNode tail=new ListNode(randomNum(),null);
        ListNode head=null;
        for(int i=1;i<length;i++){
            head=new ListNode(randomNum(),tail);
            tail=head;
        }
        return head;
    }
    private static  int randomNum(){
        return new Random().nextInt(10);
    }
    public static void printList(ListNode head){
        if(head==null){
            System.out.println("list is empty");
        }
        ListNode p=head;
        while(p!=null){
            System.out.print(p.value+" ");
            p=p.next;
        }
        System.out.println();
    }
}
