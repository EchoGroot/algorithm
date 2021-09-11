/**
 * @projectName java-training
 * @package com.yuyy.algorithm.leetcode.editor.cn
 * @className com.yuyy.algorithm.leetcode.editor.cn.恢复二叉搜索树
 */
package com.yuyy.algorithm.leetcode.editor.cn;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 恢复二叉搜索树
 * @description 恢复二叉搜索树
 * @author 余游洋
 * @date 2020/11/15 下午12:15
 * @version 1.0
 */
public class 恢复二叉搜索树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void recoverTree(TreeNode root) {
        TreeNode firstWrongNode = null;
        TreeNode seccondWrongNode = null;
        TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode tmpRootNode =root;
        while (tmpRootNode!=null||!treeNodes.isEmpty()){
            if(tmpRootNode != null){
                treeNodes.push(tmpRootNode);
                tmpRootNode=tmpRootNode.left;
            }else{
                TreeNode currNode=treeNodes.pop();
                if (firstWrongNode == null && preNode.val> currNode.val){
                    firstWrongNode = preNode;
                }
                if (firstWrongNode != null && preNode.val > currNode.val){
                    seccondWrongNode = currNode;
                }
                preNode = currNode;
                tmpRootNode=currNode.right;
            }
        }
        int tmp =firstWrongNode.val;
        firstWrongNode.val=seccondWrongNode.val;
        seccondWrongNode.val=tmp;
    }

    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left=treeNode3;
        treeNode3.right=treeNode2;
        recoverTree(treeNode1);
        System.out.println(treeNode1);
    }

}
