package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 无重复字符的最长子串_3 {

    public static void main(String[] args) {
        Solution solution = new 无重复字符的最长子串_3().new Solution();
        System.out.println(solution.lengthOfLongestSubstring(" "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Queue<Character> queue = new LinkedList<>();
            HashSet<Character> set = new HashSet<>();
            int left = 0;
            int right = 0;
            int length = 0;
            while (s.length() > right) {
                char c = s.charAt(right);
                if (set.contains(c)) {
                    length = right - left > length ? right - left : length;
                    right++;
                    queue.add(c);
                    char c1 = queue.poll();
                    left++;
                    while (c1 != c) {
                        set.remove(c1);
                        c1 = queue.poll();
                        left++;
                    }
                } else {
                    set.add(c);
                    queue.add(c);
                    right++;
                }
            }
            return right - left > length ? right - left : length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
