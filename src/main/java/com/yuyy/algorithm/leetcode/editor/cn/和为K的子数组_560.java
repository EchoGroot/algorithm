package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 和为K的子数组_560 {

    public static void main(String[] args) {
        Solution solution = new 和为K的子数组_560().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {

            // key前缀和，value出现的次数
            Map<Integer, Integer> qzh = new HashMap<>(nums.length);
            // 子串长度为0（在母串最前面），前缀和为0，出现次数+1（原本为0）
            qzh.put(0, 1);
            // 前缀和
            int sum = 0;
            int res = 0;

            for (int num : nums) {
                sum += num;
                // 找出需要的前缀和
                final Integer target = qzh.get(sum - k);
                if (target != null) {
                    res += target;
                }
                // 保存当前前缀和出现的次数
                qzh.put(sum, qzh.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
