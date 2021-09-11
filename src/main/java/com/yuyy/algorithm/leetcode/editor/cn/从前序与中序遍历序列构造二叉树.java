package com.yuyy.algorithm.leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> preorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        preorderMap = new HashMap();
        for (int j = 0; j < preorder.length; j++) {
            preorderMap.put(preorder[j], j);
        }
        return assemblyTree(inorder);
    }

    public int findRoot(int[] inorder) {
        int min = Integer.MAX_VALUE;
        int root=0;
        for (int i = 0; i < inorder.length; i++) {
            if (min>preorderMap.get(inorder[i])){
                min=preorderMap.get(inorder[i]);
                root=i;
            }
        }
        return root;
    }

    public TreeNode assemblyTree(int[] inorder) {
        int root = findRoot(inorder);
        TreeNode node = new TreeNode(inorder[root]);
        int[] leftArr = new int[root];
        int[] rightArr = new int[inorder.length - root - 1];
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (i < root) {
                leftArr[i] = inorder[i];
            }
            if (i > root) {
                rightArr[k++] = inorder[i];
            }
        }
        if (root > 0) {
            node.left = assemblyTree(leftArr);
        }
        if (root < inorder.length - 1) {
            node.right = assemblyTree(rightArr);
        }
        return node;
    }

    @Test
    public void test() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
