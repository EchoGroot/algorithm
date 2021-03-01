package com.yuyy.algorithm.leetcode.editor.cn;

public class 打家劫舍II_213 {

    public static void main(String[] args) {
        Solution solution = new 打家劫舍II_213().new Solution();
        System.out.println(solution.rob(new int[]{1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(rangeRob(nums, 0, nums.length - 2)
                    , rangeRob(nums, 1, nums.length - 1));
        }

        public int rangeRob(int[] nums, int start, int end) {
            int[][] arr = new int[nums.length][2];
            arr[start][1] = nums[start];
            arr[start][0] = 0;
            for (int i = start + 1; i <= end; i++) {
                arr[i][1] = Math.max(arr[i - 1][0] + nums[i], arr[i - 1][1]);
                arr[i][0] = Math.max(arr[i - 1][0], arr[i - 1][1]);
            }
            return Math.max(arr[end][0], arr[end][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
