package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 全排列_46 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> ans;

        private int[][] nums;

        private List<Integer> tmp;

        public List<List<Integer>> permute(int[] nums) {
            tmp = new ArrayList<>();
            ans = new ArrayList<>();
            this.nums = new int[nums.length][];
            for (int i = 0; i < nums.length; i++) {
                this.nums[i] = new int[2];
                this.nums[i][0] = nums[i];
                this.nums[i][1] = 0;
            }
            dfs();
            return this.ans;
        }

        public void dfs() {
            if (tmp.size() == nums.length) {
                List<Integer> list = new ArrayList<>();
                list.addAll(tmp);
                ans.add(list);
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i][1] == 0) {
                    nums[i][1] = 1;
                    tmp.add(nums[i][0]);
                    dfs();
                    tmp.remove(tmp.size() - 1);
                    nums[i][1] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 全排列_46().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
        System.out.println(solution.ans);
    }
}
