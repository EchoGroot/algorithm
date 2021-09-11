package com.yuyy.algorithm.leetcode.editor.cn;

public class 填充每个节点的下一个右侧节点指针_116 {

    public static void main(String[] args) {
        Solution solution = new 填充每个节点的下一个右侧节点指针_116().new Solution();
        solution.connect(new 填充每个节点的下一个右侧节点指针_116().new Node());
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.


    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            convert(root.left, root.right);
            return root;
        }

        private void convert(Node left, Node right) {
            if (left == null || right == null) {
                return;
            }
            left.next = right;
            convert(left.left, left.right);
            convert(right.left, right.right);
            convert(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
