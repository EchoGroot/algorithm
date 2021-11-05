package com.yuyy.algorithm.leetcode.editor.cn;

public class 二叉搜索树中第K小的元素_230 {

    public static void main(String[] args) {
        Solution solution = new 二叉搜索树中第K小的元素_230().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int k;
        int result;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            traverse(root);
            return result;
        }

        private void traverse(TreeNode root) {
            if (null == root) {
                return;
            }

            traverse(root.left);

            if ((--k) == 0) {
                result = root.val;
                return;
            }

            traverse(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
