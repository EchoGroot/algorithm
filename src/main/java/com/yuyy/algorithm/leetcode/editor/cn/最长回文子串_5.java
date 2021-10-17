package com.yuyy.algorithm.leetcode.editor.cn;

public class 最长回文子串_5 {

    public static void main(String[] args) {
        Solution solution = new 最长回文子串_5().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 0) {
                return null;
            }
            String max = String.valueOf(s.charAt(0));
            for (int i = 0; i < s.length(); i++) {
                String str1 = palindrome(s, i - 1, i + 1);
                String str2 = palindrome(s, i, i + 1);
                String str3 = str1.length() > str2.length() ? str1 : str2;
                if (str3.length() > max.length()) {
                    max = str3;
                }
            }
            return max;
        }

        private String palindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return s.substring(left + 1, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
