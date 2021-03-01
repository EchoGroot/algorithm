package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.Arrays;

public class 删除被覆盖区间_1288 {

    public static void main(String[] args) {
        Solution solution = new 删除被覆盖区间_1288().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            });
            int count = 0;
            int preEnd = 0;
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i][1] > preEnd) {
                    count++;
                    preEnd = intervals[i][1];
                }
            }
			return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
