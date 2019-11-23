package cn.fivejoy.dsa.others.tree;

import cn.fivejoy.dsa.jianzhi.common.TreeNode;

/**
 * @description:
 * @author: liulu
 * @create: 2019/11/10 21:21
 */
public class Tree02 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.min(getMinDepth(root.left), getMinDepth(root.right));
    }


}
