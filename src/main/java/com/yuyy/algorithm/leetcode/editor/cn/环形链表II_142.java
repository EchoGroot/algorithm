package com.yuyy.algorithm.leetcode.editor.cn;

public class 环形链表II_142{

	public static void main(String[] args) {
		Solution solution = new 环形链表II_142().new Solution();
		
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

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            // 快指针走到末端，说明没有循环
            if (fast == null || fast.next == null) {
                return null;
            }
            // 指针后移
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        // 慢指针追上快指针，说明出现了循环

        // 新建一个指针从头结点出发，和慢指针速度相同
        ListNode slow1 = head;
        while (slow!=slow1){
            slow = slow.next;
            slow1 = slow1.next;
        }
        // 两指针相遇，及找到了循环开始的节点
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
