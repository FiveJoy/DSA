package cn.fivejoy.dsa.others.tree;

import cn.fivejoy.dsa.jianzhi.common.TreeNode;

/**
 * @description:
 * 直接看是萌的。
 * 但是仔细用递归一想，就非常简单了'
 * @author: liulu
 * @create: 2019/11/10 21:49
 */
public class Tree05 {
    public int countNodeofTreeKfloor(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int countLeft = countNodeofTreeKfloor(root.left, k - 1);
        int countRight = countNodeofTreeKfloor(root.right, k - 1);
        return countLeft + countRight;
    }
}
