package com.yuyy.algorithm.leetcode.editor.cn;

public class 回文链表_234 {

    public static void main(String[] args) {
        Solution solution = new 回文链表_234().new Solution();

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
        public boolean isPalindrome(ListNode head) {
            // 注意链表长度为1的情况

            // 利用快慢指针找出链表中点
            ListNode dummy = new ListNode(-1, head);
            ListNode slow = dummy, fast = dummy;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast.next != null) {
                    fast = fast.next;
                }
            }

            // 反转后半段链表
            ListNode pre = null;
            ListNode curr = slow.next;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }

            // 前半段链表和反转过的后半段链表相比较
            ListNode front = head, back = pre;
            while (back != null) {
                if (front.val != back.val) {
                    return false;
                }
                front = front.next;
                back = back.next;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
