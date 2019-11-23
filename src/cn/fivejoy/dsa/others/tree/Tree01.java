package cn.fivejoy.dsa.others.tree;

import cn.fivejoy.dsa.jianzhi.common.TreeNode;

/**
 * @description:
 * @author: liulu
 * @create: 2019/11/10 21:17
 */
public class Tree01 {
    public static void main(String[] args) {

    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }
}
