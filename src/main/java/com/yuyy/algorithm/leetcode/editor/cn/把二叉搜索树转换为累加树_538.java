package com.yuyy.algorithm.leetcode.editor.cn;

public class 把二叉搜索树转换为累加树_538{

	public static void main(String[] args) {
		Solution solution = new 把二叉搜索树转换为累加树_538().new Solution();
		
	}
	
//leetcode submit region begin(Prohibit modification and deletion)

   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
class Solution {
    int sum=0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (null == root) {
            return;
        }

        traverse(root.right);

        sum += root.val;
        root.val = sum;

        traverse(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
