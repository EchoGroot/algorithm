package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串_76 {
    public static void main(String[] args) {
        Solution solution = new 最小覆盖子串_76().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> needs = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for (char c :
                    t.toCharArray()) {
                needs.put(c, needs.get(c) == null ? 1 : needs.get(c) + 1);
            }
            int left = 0;
            int right = 0;
            int valid = 0;
            int start = 0;
            int length = Integer.MAX_VALUE;
            while (right < s.length()) {
                char c = s.charAt(right++);
                if (needs.containsKey(c)) {
                    window.put(c, window.get(c) == null ? 1 : window.get(c)+1);
                    if (window.get(c).equals(needs.get(c))) {
                        valid++;
                        while (valid==needs.size()) {
                            if (length > right - left) {
                                length = right - left;
                                start = left;
                            }
                            char c1 = s.charAt(left++);
                            if (window.containsKey(c1)) {
                                if (window.get(c1).equals(needs.get(c1))) {
                                    valid--;
                                }
                                window.put(c1, window.get(c1) - 1);
                            }
                        }
                    }
                }
            }
            return length == Integer.MAX_VALUE ? "" : s.substring(start,start +length);
        }
    }
	//leetcode submit region end(Prohibit modification and deletion)
}
