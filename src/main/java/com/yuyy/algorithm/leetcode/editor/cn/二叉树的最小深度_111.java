package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最小深度_111 {
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
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

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> treeNodes = new LinkedList<>();
            treeNodes.add(root);
            int step = 1;
            while (!treeNodes.isEmpty()) {
                int size = treeNodes.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = treeNodes.poll();
                    if (node.left == null && node.right == null) {
                        return step;
                    }
                    if (node.left != null) {
                        treeNodes.add(node.left);
                    }
                    if (node.right != null) {
                        treeNodes.add(node.right);
                    }
                }
                step++;
            }
            return step;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 二叉树的最小深度_111().new Solution();
        Solution.TreeNode treeNode3 = solution.new TreeNode(3);
        Solution.TreeNode treeNode9 = solution.new TreeNode(9);
        Solution.TreeNode treeNode20 = solution.new TreeNode(20);
        Solution.TreeNode treeNode15 = solution.new TreeNode(15);
        Solution.TreeNode treeNode7 = solution.new TreeNode(7);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        System.out.println(solution.minDepth(treeNode3));

    }
}
