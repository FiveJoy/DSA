package cn.fivejoy.dsa.others.tree;

import cn.fivejoy.dsa.jianzhi.common.TreeNode;

/**
 * @description:
 * @author: liulu
 * @create: 2019/11/10 21:40
 */
public class Tree03 {
    public int countNodeofTree(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+countNodeofTree(root.right)+countNodeofTree(root.left);
    }
}
