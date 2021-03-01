package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class 合并区间_56 {

    public static void main(String[] args) {
        Solution solution = new 合并区间_56().new Solution();
        int[][] merge = solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(merge);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            });
            int start = intervals[0][0];
            int end = intervals[0][1];
            int[][] result = new int[intervals.length][2];
            ArrayList<int[]> ans = new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i][0] > end) {
                    ans.add(new int[]{start, end});
                    start = intervals[i][0];
                    end = intervals[i][1];
                } else if (intervals[i][1] > end) {
                    end = intervals[i][1];
                }
            }
            ans.add(new int[]{start, end});
            return ans.toArray(new int[ans.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
