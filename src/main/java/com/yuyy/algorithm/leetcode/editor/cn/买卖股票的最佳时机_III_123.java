package com.yuyy.algorithm.leetcode.editor.cn;

public class 买卖股票的最佳时机_III_123 {

    public static void main(String[] args) {
        Solution solution = new 买卖股票的最佳时机_III_123().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }

            int[][][] arr = new int[prices.length][3][2];
            arr[0][2][1] = -prices[0];
            arr[0][2][0] = 0;
            arr[0][1][1] = -prices[0];
            arr[0][1][0] = 0;
            arr[0][0][0] = 0;
            for (int i = 1; i < prices.length; i++) {
                arr[i][2][0] = Math.max(arr[i - 1][2][0], arr[i - 1][2][1] + prices[i]);
                arr[i][2][1] = Math.max(arr[i - 1][2][1], arr[i - 1][1][0] - prices[i]);
                arr[i][1][0] = Math.max(arr[i - 1][1][0], arr[i - 1][1][1] + prices[i]);
                arr[i][1][1] = Math.max(arr[i - 1][1][1], arr[i - 1][0][0] - prices[i]);
            }
            return arr[prices.length - 1][2][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
