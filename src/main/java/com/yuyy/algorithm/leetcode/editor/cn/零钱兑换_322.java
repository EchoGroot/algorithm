package com.yuyy.algorithm.leetcode.editor.cn;

public class 零钱兑换_322 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] coins;
        private int[] memo; //备忘录

        public int coinChange(int[] coins, int amount) {
            this.coins = coins;
            this.memo = new int[amount + 1];
            return dp(amount);
        }

        private int dp(int amount) {
            if (amount == 0) {
                return 0;
            }
            if (memo[amount] != 0) {
                return memo[amount];
            }
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (amount < coins[i]) {
                    continue;
                }
                int dpcoins = dp(amount - coins[i]) + 1;
                result = Math.min(result, dpcoins == 0 ? Integer.MAX_VALUE : dpcoins);
            }
            return memo[amount] = (result == Integer.MAX_VALUE ? -1 : result);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 零钱兑换_322().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 100));
    }
}
