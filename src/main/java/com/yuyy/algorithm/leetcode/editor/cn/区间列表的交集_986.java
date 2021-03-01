package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.ArrayList;

public class 区间列表的交集_986 {

    public static void main(String[] args) {
        Solution solution = new 区间列表的交集_986().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            ArrayList<int[]> list = new ArrayList<>();
            int pointer = 0;
            int pointer1 = 0;
            while (pointer < firstList.length && pointer1 < secondList.length) {
                int n1 = Math.min(firstList[pointer][1], secondList[pointer1][1]);
                int n0 = Math.max(firstList[pointer][0], secondList[pointer1][0]);
                if (n1 >= n0) {
                    list.add(new int[]{n0, n1});
                }
                if (firstList[pointer][1] > secondList[pointer1][1]) {
                    pointer1++;
                } else {
                    pointer++;
                }
            }
            return list.toArray(new int[list.size()][]);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}

