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

            // 找到下一个反转区间内的头结点
            ListNode nextHead = head;
            for (int i = 0; i < k; i++) {
                // 如果长度不到k，就不反转
                if (nextHead == null) {
                    return head;
                }
                nextHead = nextHead.next;
            }

            // 反转两个节点内的链表
            ListNode newHead = reverse(head, nextHead);

            // 利用递归拆解重复问题
            head.next = reverseKGroup(nextHead, k);
            return newHead;
        }

        private ListNode reverse(ListNode headCopy, ListNode tail) {
            ListNode curr = headCopy;
            ListNode pre = null;

            while (curr != tail) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }

            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
