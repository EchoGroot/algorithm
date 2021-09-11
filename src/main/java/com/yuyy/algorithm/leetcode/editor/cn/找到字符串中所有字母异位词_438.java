package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 找到字符串中所有字母异位词_438 {
    public static void main(String[] args) {
        Solution solution = new 找到字符串中所有字母异位词_438().new Solution();
        System.out.println(solution.findAnagrams("", "a"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            HashMap<Character, Integer> needs = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            ArrayList<Integer> ans = new ArrayList<>();
            int valid = 0;
            for (char c :
                    p.toCharArray()) {
                needs.put(c, needs.getOrDefault(c, 0) + 1);
            }
            for (int i = 0; i < p.length() && i < s.length(); i++) {
                window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0) + 1);
                if (window.get(s.charAt(i)).equals(needs.get(s.charAt(i)))) {
                    valid++;
                }
            }
            if (valid == needs.size() && valid != 0) {
                ans.add(0);
            }
            for (int i = 0; i < s.length() - p.length(); i++) {
                if (needs.containsKey(s.charAt(i))) {
                    if (needs.get(s.charAt(i)).equals(window.get(s.charAt(i)))) {
                        valid--;
                    }
                    window.put(s.charAt(i), window.get(s.charAt(i)) - 1);
                }
                char c = s.charAt(i + p.length());
                if (needs.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (needs.get(c).equals(window.get(c))) {
                        valid++;
                    }
                }
                if (valid == needs.size()) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }

        public List<Integer> findAnagrams1(String s, String p) {
            HashMap<Character, Integer> needs = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            ArrayList<Integer> ans = new ArrayList<>();
            for (char c :
                    p.toCharArray()) {
                needs.put(c, needs.getOrDefault(c, 0) + 1);
            }
            int left = 0;
            int right = 0;
            int valid = 0;
            while (right < s.length()) {
                char c = s.charAt(right++);
                if (needs.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (needs.get(c).equals(window.get(c))) {
                        valid++;
                    }
                }
                while (right - left >= p.length()) {
                    if (valid == needs.size()) {
                        ans.add(left);
                    }
                    char c1 = s.charAt(left++);
                    if (needs.containsKey(c1)) {
                        if (window.get(c1).equals(needs.get(c1))) {
                            valid--;
                        }
                        window.put(c1, window.get(c1) - 1);
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
