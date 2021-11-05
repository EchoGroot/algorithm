package com.yuyy.algorithm.leetcode.editor.cn;

public class 最大二叉树_654 {

    public static void main(String[] args) {
        Solution solution = new 最大二叉树_654().new Solution();
        System.out.println(solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));

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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return constructMaximumBinaryTreeWithIndex(nums, 0, nums.length);
        }

        private TreeNode constructMaximumBinaryTreeWithIndex(int[] nums, int start, int end) {
            if (end - start < 1 || start >= nums.length) {
                return null;
            }
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int i = start; i < end; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            final TreeNode root = new TreeNode(max);
            root.left = constructMaximumBinaryTreeWithIndex(nums, start, maxIndex);
            root.right = constructMaximumBinaryTreeWithIndex(nums, maxIndex + 1, end);
            return root;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
