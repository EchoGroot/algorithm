package com.yuyy.algorithm.leetcode.editor.cn;

public class 二分查找_704{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
		int left =0;
		int right = nums.length-1;
		while (left <= right) {
            int mid = left + ((right - left) >> 1);
			if (nums[mid] < target) {
				left = mid+1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

	public static void main(String[] args) {
		Solution solution = new 二分查找_704().new Solution();
		System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
	}
}
