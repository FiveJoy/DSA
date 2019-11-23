package cn.fivejoy.dsa.others.tree;

import cn.fivejoy.dsa.jianzhi.common.TreeNode;

/**
 * @description:
 * @author: liulu
 * @create: 2019/11/10 21:47
 */
public class Tree04 {
    public int countLeafofTree(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return countLeafofTree(root.left)+countLeafofTree(root.right);
    }
}
