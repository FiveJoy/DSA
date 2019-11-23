package cn.fivejoy.dsa.now.chapter7;

import java.util.Stack;

/**
 * @description: 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能
 * 使用递归函数。如何实现
 * <p>
 * <p>
 * 斐波那契数列用 O(logn)实现
 * @author: liulu
 * @create: 2019/11/23 17:10
 */
public class Nno6 {
    /**
     * 要是可以申请，就可以再申请一个栈，然后从原栈弹出一个放到新栈，挨个这么干，
     * 但是不让申请，就想起递归，递归本身就是一个计算机方法栈
     * 通过return的值保存前一步的结果。然后这一步用上这个return的值
     *
     * @param stack
     */
    public void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int i=returnAndRemoveStackBottom(stack); //移除并返回栈底元素
        returnAndRemoveStackBottom(stack);
        stack.push(i);
    }

    /**
     * 对于一个栈，移除栈底元素，并返回这个栈底元素
     * basecase
     * <p>
     * 状态变化
     */
    public int returnAndRemoveStackBottom(Stack<Integer> stack) {
        int k = stack.pop();
        if (stack.isEmpty()) {
            return k;
        }

        int last = returnAndRemoveStackBottom(stack);
        stack.push(k);
        return last;
    }
}
/**
 * 计算机 发明的目的是
 * 怎么试
 * 而不是 怎么算
 * 是图灵为了试 如何破解的时候 才搞出来的计算机
 */