package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 寻找重复的子树_652 {

    public static void main(String[] args) {
        Solution solution = new 寻找重复的子树_652().new Solution();

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
        private List<TreeNode> res = new ArrayList<>();
        private Map<String, Integer> memo = new HashMap<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            serializeNode(root);
            return res;
        }

        private String serializeNode(TreeNode root) {
            if (root == null) {
                return "#";
            }

            String left = serializeNode(root.left);
            String right = serializeNode(root.right);
            // 序列化二叉树
            String curr = left + "," + right + "," + root.val;

            Integer count = memo.getOrDefault(curr, 0);
            if (count == 1) {
                res.add(root);
            }
            memo.put(curr, count + 1);
            return curr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
