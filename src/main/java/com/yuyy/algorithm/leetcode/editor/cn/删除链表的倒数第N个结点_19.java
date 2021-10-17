package com.yuyy.algorithm.leetcode.editor.cn;

public class 删除链表的倒数第N个结点_19{

	public static void main(String[] args) {
		Solution solution = new 删除链表的倒数第N个结点_19().new Solution();
		
	}

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
	
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = null;
        int i = 1;
        while (fast != null) {
            if (i == n+1) {
                slow = head;
            }else if (i>n+1){
                slow = slow.next;
            }
            fast = fast.next;
            i++;
        }

        // 因为slow是删除节点的前一个，所以存在特殊情况
        // 一、删除节点是第一个，slow为空，通过长度来判断这种情况
        if (i - 1 == n) {
            return head.next;
        }

        // 二。删除节点是头结点之前的，直接返回头结点
        if (slow == null) {
            return head;
        }

        // 删除节点slow.next
        slow.next = slow.next.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
