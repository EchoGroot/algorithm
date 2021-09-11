package com.yuyy.algorithm.leetcode.editor.cn;

public class 合并两个有序链表_21 {

    public static void main(String[] args) {
        Solution solution = new 合并两个有序链表_21().new Solution();

    }


    // Definition for singly-linked list.
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
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 虚拟头结点挺有用的
            ListNode dummy = new ListNode();
            // 结果链表的指针
            ListNode p = dummy;
            // 双指针
            ListNode p1 = l1;
            ListNode p2 = l2;
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p.next = p1;
                    // 双指针移动
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                // 别忘了结果指针也要移动
                p = p.next;
            }
            // 将长的那节直接和结果链表接上
            if (p1 != null) {
                p.next = p1;
            } else {
                p.next = p2;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
