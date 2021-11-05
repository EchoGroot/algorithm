package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

public class 二叉树的序列化与反序列化_297 {

    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}
    }

    class Codec {
        private String SEP = ",";
        private String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return NULL;
            }
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(TreeNode root,StringBuilder sb) {
            if (root == null) {
                sb.append(NULL);
            }
            String left = serialize(root.left);
            String right = serialize(root.right);
            sb.append(root.val).append(SEP)
              .append(left).append(SEP)
              .append(right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (NULL.equals(data)) {
                return null;
            }
            LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEP)));
            return deserialize(nodes);
        }

        private TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) {
                return null;
            }

            String currValue = nodes.pop();
            if (NULL.equals(currValue)) {
                return null;
            }

            TreeNode currNode = new TreeNode(Integer.parseInt(currValue));
            TreeNode leftNode = deserialize(nodes);
            TreeNode rightNode = deserialize(nodes);
            currNode.left = leftNode;
            currNode.right = rightNode;
            return currNode;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
