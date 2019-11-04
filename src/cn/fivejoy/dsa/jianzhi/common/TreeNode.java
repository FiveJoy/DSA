package cn.fivejoy.dsa.jianzhi.common;

/**
 * @description:
 * @author: liululu
 * @create: 2019/10/28 11:37
 */
public class TreeNode {
    public String value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(String value) {
        this.value = value;
    }

    public TreeNode(String value,TreeNode left,TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

