package com.yuyy.algorithm.leetcode.editor.cn;

public class 相交链表_160 {

    public static void main(String[] args) {
        Solution solution = new 相交链表_160().new Solution();

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            ListNode res = null;

            ListNode p1 = headA;
            ListNode p2 = headB;
            boolean concat1 = false;
            boolean concat2 = false;
            while (true) {
                if (p1 == null) {
                    // 已经连接过
                    if (concat1) {
                        break;
                    } else {
                        // 连接链表
                        p1 = headB;
                        concat1 = true;
                    }
                }
                if (p2 == null) {
                    if (concat2) {
                        break;
                    } else {
                        p2 = headA;
                        concat2 = true;
                    }
                }
                // 相交了
                if (p1 == p2) {
                    res = p1;
                    break;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
