package com.yuyy.algorithm.leetcode.editor.cn;

public class 反转链表_206 {

    public static void main(String[] args) {
        Solution solution = new 反转链表_206().new Solution();

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode curr = head;
            // 虚拟头结点
            ListNode pre = null;

            do {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            } while (curr != null);

            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
