package com.yuyy.algorithm.leetcode.editor.cn;

public class 环形链表_141{

	public static void main(String[] args) {
		Solution solution = new 环形链表_141().new Solution();
		
	}
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            // 快指针走到末端，说明没有循环
            if (fast == null || fast.next == null) {
                return false;
            }
            // 指针后移
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        // 慢指针追上快指针，说明出现了循环
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
