package cn.fivejoy.dsa.leet;

import cn.fivejoy.dsa.jianzhi.common.TreeNode;

import static cn.fivejoy.dsa.temp.TraverseTree.visit;

/**
 * @description: https://leetcode-cn.com/problems/invert-binary-tree/
 * @author: liulu
 * @create: 2019/11/09 12:34
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.right=right;
        root.left=left;
        return root;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        visit(root);
        preOrder(root.left);
        preOrder(root.right);

    }
}
