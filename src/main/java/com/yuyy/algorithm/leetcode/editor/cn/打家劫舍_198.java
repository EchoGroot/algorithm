package com.yuyy.algorithm.leetcode.editor.cn;

public class 打家劫舍_198 {

    public static void main(String[] args) {
        Solution solution = new 打家劫舍_198().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[][] arr = new int[nums.length][2];
            arr[0][1] = nums[0];
            arr[0][0] = 0;
            for (int i = 1; i < nums.length; i++) {
                arr[i][1] = Math.max(arr[i - 1][0] + nums[i], arr[i - 1][1]);
                arr[i][0] = Math.max(arr[i - 1][0], arr[i - 1][1]);
            }
            return Math.max(arr[nums.length - 1][0], arr[nums.length - 1][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
