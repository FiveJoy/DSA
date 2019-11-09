package cn.fivejoy.dsa.jianzhi.common;

/**
 * @description:
 * @author: liululu
 * @create: 2019/10/20 16:43
 */
public class ListNode {
  public  int value;
  public  ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }
}
