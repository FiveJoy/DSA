package cn.fivejoy.dsa.temp;

import apple.laf.JRSUIUtils;
import cn.fivejoy.dsa.jianzhi.common.TreeNode;

import java.util.Stack;

/**
 * @description:
 * @author: liululu
 * @create: 2019/10/25 09:57
 */
public class TraverseTree {
    public static void printByPreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            visit(p);
            p = p.left;
        }
        while (!stack.empty()) {
            p = stack.pop();

            p = p.right;
            while (p != null) {
                stack.push(p);
                visit(p);
                p = p.left;
            }
        }
    }

    public static void betterPrintByPreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (!stack.empty() || p != null) {
            while (p != null) {
                stack.push(p);
                visit(p);
                p = p.left;
            }
            if (!stack.empty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    public static void visit(TreeNode p) {
        if (p != null) {
            System.out.print(p.value + " ");
        }
    }

    public static void printByPreOrderReverse(TreeNode root) {
        if (root != null) {
            visit(root);
            printByPreOrderReverse(root.left);
            printByPreOrderReverse(root.right);
        }
    }
    public static void printByInOrderReverse(TreeNode root){
        if(root!=null){
            printByInOrderReverse(root.left);
            visit(root);
            printByInOrderReverse(root.right);
        }
    }
    public static void printByInOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;

        }
        while (!stack.empty()) {
            p = stack.pop();
            visit(p);
            p = p.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }
    }

    //简单创建一个简单的二叉树
    public static TreeNode createBT(){
        TreeNode i = new TreeNode("I");
        TreeNode h = new TreeNode("H");
        TreeNode g = new TreeNode("G");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F", h, i);
        TreeNode d = new TreeNode("D", null, g);
        TreeNode c = new TreeNode("C", f, null);
        TreeNode b = new TreeNode("B", d, e);
        TreeNode root = new TreeNode("A", b, c);
        return root;
    }
    public static void levelOrder(TreeNode root){

    }

    public static void main(String[] args) {
        //简单创建普通二叉树
        TreeNode root = createBT();
        System.out.println("递归实现前序遍历");
        printByPreOrderReverse(root);
        System.out.println("\n非递归实现前序遍历-1");
        betterPrintByPreOrder(root);
        System.out.println("\n非递归实现前序遍历-2");
        printByPreOrder(root);

        System.out.println("\n********************************");
        System.out.println("\n递归实现中序遍历");
        printByInOrderReverse(root);
        System.out.println("\n非递归实现中序遍历-1");
        printByInOrder(root);
//        System.out.println("\n非递归实现中序遍历-2");
//        printByPreOrder(root);
//        System.out.println("\n********************************");
//        System.out.println("\n递归实现后序遍历");
//        printByPreOrderReverse(root);
//        System.out.println("\n非递归实现后序遍历-1");
//        betterPrintByPreOrder(root);
//        System.out.println("\n非递归实现后序遍历-2");
//        printByPreOrder(root);
//        System.out.println("\n********************************");
//        //非递归实现层次遍历
//        levelOrder(root);
    }
}
