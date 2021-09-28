package com.yuyy.algorithm.leetcode.editor.cn;

public class K个一组翻转链表_25 {

    public static void main(String[] args) {
        Solution solution = new K个一组翻转链表_25().new Solution();

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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode tail = head;
            ListNode headCopy = head;
            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    return head;
                }
                tail = tail.next;
            }

            ListNode newHead = reverse(headCopy, tail);
            headCopy.next = reverseKGroup(tail, k);
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
