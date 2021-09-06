package com.yuyy.algorithm.leetcode.editor.cn;

public class 链表的中间结点_876 {

    public static void main(String[] args) {
        Solution solution = new 链表的中间结点_876().new Solution();

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
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;
            int length = 1;
            while ((fast = fast.next) != null) {
                length++;
                if (length % 2 != 0) {
                    slow = slow.next;
                }
            }
            // 长度为偶数时，中间节点取后面个
            if (length % 2 == 0) {
                slow = slow.next;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
