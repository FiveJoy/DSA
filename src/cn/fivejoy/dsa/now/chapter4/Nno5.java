package cn.fivejoy.dsa.now.chapter4;

import cn.fivejoy.dsa.jianzhi.common.TreeNode;

import java.util.Stack;

/**
 * @description:
 * @author: liululu
 * @create: 2019/10/28 11:36
 */
public class Nno5 {

    public static void reversePreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        reversePreOrder(root.left);
        reversePreOrder(root.right);
    }

    public static void reverseInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        reverseInOrder(root.left);
        System.out.print(root.value + " ");
        reverseInOrder(root.right);
    }

    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                System.out.print(root.value + " ");
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.value + " ");
                root = root.right;
            }
        }
    }

    public static void postOrderReverse(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderReverse(root.left);
        postOrderReverse(root.right);
        System.out.print(root.value + " ");
    }

    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        TreeNode lastVisit = null;
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {

            root = stack.pop();

            if (root.right == null || root.right == lastVisit) {
                System.out.print(root.value + " ");
                lastVisit = root;
            } else {
                stack.push(root);
                root=root.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

            }


        }
    }

    //简单创建一个简单的二叉树
    public static TreeNode createBT() {
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

    public static void levelOrder(TreeNode root) {

    }

    public static void main(String[] args) {
        //简单创建普通二叉树
        TreeNode root = createBT();
        System.out.println("递归实现前序遍历");
        reversePreOrder(root);
        System.out.println("\n非递归实现前序遍历 ");
        preOrder(root);

        System.out.println("\n********************************");
        System.out.println("\n递归实现中序遍历");
        reverseInOrder(root);
        System.out.println("\n非递归实现中序遍历");
        inOrder(root);
        System.out.println("\n********************************");
        System.out.println("\n递归实现后序遍历");
        postOrderReverse(root);
        System.out.println("\n非递归实现后序遍历-1");
        postOrder(root);
        System.out.println("\n********************************");
        //非递归实现层次遍历
//        levelOrder(root);
    }
}
