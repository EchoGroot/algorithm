package com.yuyy.algorithm.leetcode.editor.cn;

public class 两数之和II_输入有序数组_167{

	public static void main(String[] args) {
		Solution solution = new 两数之和II_输入有序数组_167().new Solution();
		
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
		int left=0;
		int right=numbers.length-1;
		while (left < right) {
			int sum=numbers[left]+numbers[right];
			if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			}else {
				return new int[]{++left, ++right};
			}
		}
		return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
