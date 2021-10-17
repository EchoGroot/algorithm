package com.yuyy.algorithm.leetcode.editor.cn;

public class 反转链表II_92 {

    public static void main(String[] args) {
        Solution solution = new 反转链表II_92().new Solution();
        final ListNode listNode5 = new ListNode(5);
        final ListNode listNode3 = new ListNode(3, listNode5);
        // final ListNode listNode3 = new ListNode(3, listNode4);
        // final ListNode listNode2 = new ListNode(2, listNode3);
        // final ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println(solution.reverseBetween(listNode3, 1, 1));
    }

    public static class ListNode {
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null) {
                return null;
            }

            // 虚拟头结点
            final ListNode dummy = new ListNode(-1, head);
            ListNode curr = dummy;

            // 前进left，这段不用反转
            for (int i = 0; i < left - 1; i++) {
                curr = curr.next;
                if (curr == null) {
                    return head;
                }
            }

            // 反转数量为right - left + 1的节点
            curr.next = reverse(curr.next, right - left + 1);

            return dummy.next;
        }

        private ListNode reverse(ListNode head, int size) {
            if (head == null || size == 0) {
                return head;
            }
            ListNode curr = head;
            ListNode pre = null;

            // 开始反转，增加了个数量限制
            do {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
                size--;
            } while (curr != null && size > 0);

            // right后的节点接到反转区间的头结点
            if (curr != null) {
                head.next = curr;
            }

            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
