package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和_15 {

    public static void main(String[] args) {
        Solution solution = new 三数之和_15().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length-2; i++) {
                if (nums[i]>0){
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                twoSum(nums, -nums[i], i + 1);
            }
            return ans;
        }

        public void twoSum(int[] numbers, int target, int start) {
            int left = start;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers[start - 1]);
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    ans.add(list);
                    while (left < right && numbers[left] == numbers[++left]);
                    while (left < right && numbers[right] == numbers[--right]);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
