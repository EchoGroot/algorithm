package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.HashMap;

public class 两数之和_1 {

    public static void main(String[] args) {
        Solution solution = new 两数之和_1().new Solution();
        solution.twoSum(new int[]{3, 2, 4}, 6);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    continue;
                }
                map.put(target - nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i]) && i!=map.get(nums[i])) {
                    return new int[]{i, map.get(nums[i])};
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
