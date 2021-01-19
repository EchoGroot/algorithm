package com.yuyy.algorithm.leetcode.editor.cn;

import org.junit.Test;

public class 二叉树中的最大路径和 {

    private Integer RES=Integer.MIN_VALUE;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        maxPathLength(root);
        return RES;
    }

    public int maxPathLength(TreeNode node){
        if(null==node){
            return 0;
        }
        int leftLength=Math.max(0,maxPathLength(node.left));
        int rightLength=Math.max(0,maxPathLength(node.right));
        RES=Math.max(leftLength+rightLength+node.val,RES);
        return Math.max(leftLength,rightLength)+node.val;
    }

    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(-1);
        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left=treeNode2;
//        treeNode1.right=treeNode3;
        System.out.println( maxPathSum(treeNode1));
    }
}
