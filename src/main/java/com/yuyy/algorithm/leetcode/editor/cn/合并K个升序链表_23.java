package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 合并K个升序链表_23 {

    public static void main(String[] args) {
        Solution solution = new 合并K个升序链表_23().new Solution();

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
        public ListNode mergeKLists(ListNode[] lists) {
            // 边界问题得注意
            if (lists.length == 0) {
                return null;
            }
            // 虚拟头节点
            ListNode dummy = new ListNode();
            ListNode p = dummy;
            ListNode temp;
            // 利用优先队列优化，不然每次都需要对所有头结点遍历，优先队列的好处就是可以动态的调整内部顺序
            final Queue<ListNode> listNodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            for (ListNode listNode : lists) {
                // 边界问题得注意
                if (listNode == null) {
                    continue;
                }
                listNodes.offer(listNode);
            }

            // 多路归并
            while ((temp = listNodes.poll()) != null) {
                p.next = temp;
                p = p.next;
                if (temp.next != null) {
                    listNodes.offer(temp.next);
                }
            }
            
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
