package com.yuyy.algorithm.leetcode.editor.cn;

public class 验证回文串_125 {

    public static void main(String[] args) {
        Solution solution = new 验证回文串_125().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }
            int left = 0, right = s.length() - 1;
            while (right > left) {
                char leftChar = s.charAt(left);
                if (!((leftChar >= 'a' && leftChar <= 'z')
                      || (leftChar >= 'A' && leftChar <= 'Z')
                      || (leftChar >= '0' && leftChar <= '9'))) {
                    left++;
                    continue;
                }
                char rightChar = s.charAt(right);
                if (!((rightChar >= 'a' && rightChar <= 'z')
                      || (rightChar >= 'A' && rightChar <= 'Z')
                      || (rightChar >= '0' && rightChar <= '9'))) {
                    right--;
                    continue;
                }
                if ((s.charAt(left++) | 0x20) != (s.charAt(right--) | 0x20)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
