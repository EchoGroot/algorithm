package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树_106 {

    public static void main(String[] args) {
        Solution solution = new 从中序与后序遍历序列构造二叉树_106().new Solution();

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private Map<Integer, Integer> postorderMap;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (postorder.length == 0) {
                return null;
            }
            postorderMap = new HashMap();
            for (int j = 0; j < postorder.length; j++) {
                postorderMap.put(postorder[j], j);
            }
            return assemblyTree(inorder);
        }

        public int findRoot(int[] inorder) {
            int max = Integer.MIN_VALUE;
            int root = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (max < postorderMap.get(inorder[i])) {
                    max = postorderMap.get(inorder[i]);
                    root = i;
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}
