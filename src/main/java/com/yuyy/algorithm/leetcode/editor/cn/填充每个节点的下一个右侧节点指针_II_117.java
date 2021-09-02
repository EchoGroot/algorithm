package com.yuyy.algorithm.leetcode.editor.cn;

public class 填充每个节点的下一个右侧节点指针_II_117 {

    public static void main(String[] args) {
        Solution solution = new 填充每个节点的下一个右侧节点指针_II_117().new Solution();

        final Node node1 = new Node(1);
        final Node node2 = new Node(2);
        final Node node3 = new Node(3);
        final Node node4 = new Node(4);
        final Node node5 = new Node(5);
        final Node node6 = new Node(6);
        final Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;
        solution.connect(node1);

    }


    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

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
    class Solution {

        /**
         * 下一层的头结点
         */
        private Node nextRowHead;
        /**
         * 下一层的尾结点
         */
        private Node nextRowTail;

        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Node curr = root;

            do {
                // 内层循环结束后curr为null，但第一次进来时不需要赋值，此时为root
                if (curr == null) {
                    // 从下一行的头结点开始遍历
                    curr = nextRowHead;
                    nextRowHead = null;
                }

                do {
                    buildNextRow(curr.left);
                    buildNextRow(curr.right);
                    curr = curr.next;
                    // 当前层的下一个节点
                } while (curr != null);
                // 下一层
            } while (nextRowHead != null);
            return root;
        }

        /**
         * 将下一层的节点串起来
         */
        private void buildNextRow(Node node) {
            if (node != null) {
                if (nextRowHead == null) {
                    nextRowHead = node;
                    nextRowTail = node;
                } else {
                    nextRowTail.next = node;
                    nextRowTail = node;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
