package com.yuyy.algorithm.leetcode.editor.cn;

public class 斐波那契数_509 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] note;

        public int fib(int n) {
            if (n < 2) {
                return n;
            }
            note = new int[n + 1];
            note[0] = 0;
            note[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                note[i] = note[i - 1] + note[i - 2];
            }
            return note[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 斐波那契数_509().new Solution();

    }
}
