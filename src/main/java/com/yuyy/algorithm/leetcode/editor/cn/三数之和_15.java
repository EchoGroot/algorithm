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
            // 排序是为了使用双指针求和
            Arrays.sort(nums);
            // 分解为两数之和+第三个数，这个循环是第三个数的取值
            for (int i = 0; i < nums.length - 2; i++) {
                // 由于和为零，并且每次运算时第三个数的下标最小，所以第三个数不可能大于0
                if (nums[i] > 0) {
                    break;
                }
                // 排除第三个数重复的情况，另外两数也会做类似处理
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
            // 双指针求和
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
                    // 去重
                    while (left < right && numbers[left] == numbers[++left]) ;
                    while (left < right && numbers[right] == numbers[--right]) ;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
